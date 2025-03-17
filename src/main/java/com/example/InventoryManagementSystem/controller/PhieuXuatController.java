package com.example.InventoryManagementSystem.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.InventoryManagementSystem.dto.SanPhamChiTietDto;
import com.example.InventoryManagementSystem.dto.SanPhamChiTietProjection;
import com.example.InventoryManagementSystem.service.CongNgheService;
import com.example.InventoryManagementSystem.service.SanPhamChiTietService;
import com.example.InventoryManagementSystem.service.SwingWeightService;
import com.example.InventoryManagementSystem.service.ThuongHieuService;
import com.example.InventoryManagementSystem.service.TrongLuongService;
import com.example.InventoryManagementSystem.service.XuatXuService;

@Controller
@RequestMapping("/phieu-xuat")
public class PhieuXuatController {
    private final SanPhamChiTietService sanPhamChiTietService;
    private final ThuongHieuService thuongHieuService;
    private final XuatXuService xuatXuService;
    private final SwingWeightService swingWeightService;
    private final TrongLuongService trongLuongService;
    private final CongNgheService congNgheService;
    public PhieuXuatController(SanPhamChiTietService sanPhamChiTietService, ThuongHieuService thuongHieuService,
            XuatXuService xuatXuService, SwingWeightService swingWeightService, TrongLuongService trongLuongService,
            CongNgheService congNgheService) {
        this.sanPhamChiTietService = sanPhamChiTietService;
        this.thuongHieuService = thuongHieuService;
        this.xuatXuService = xuatXuService;
        this.swingWeightService = swingWeightService;
        this.trongLuongService = trongLuongService;
        this.congNgheService = congNgheService;
    }

    @GetMapping("/hien-thi")
    public String listPhieuNhap(Model model) {          
        model.addAttribute("content", "views/PhieuXuatHienThi");        
        return "Home/TrangChu";
    }

    @GetMapping("/tao-phieu-xuat")
    public String listSanPhamCt(Model model, @RequestParam(defaultValue = "0") int page) {
        // Gọi hàm load sản phẩm (nếu có điều kiện tìm kiếm, các giá trị sẽ là null ban
        // đầu)
        loadSanPhamChiTiet(model, page, null, null, null, null, null, null, null, null);

        // Thiết lập giá trị lọc (selected) ban đầu là null
        model.addAttribute("selectedXuatXu", null);
        model.addAttribute("selectedThuongHieu", null);
        model.addAttribute("selectedCongNghe", null);
        model.addAttribute("selectedTrongLuong", null);
        model.addAttribute("selectedSwingWeight", null);

        // Truyền danh sách filter với tên mới: listXuatXu, listThuongHieu,
        // listCongNghe, listTrongLuong, listSwingWeight
        model.addAttribute("listXuatXu", xuatXuService.listXuatXus());
        model.addAttribute("listThuongHieu", thuongHieuService.listThuongHieu());
        model.addAttribute("listCongNghe", congNgheService.listCongNghe());
        model.addAttribute("listTrongLuong", trongLuongService.listTrongLuongs());
        model.addAttribute("listSwingWeight", swingWeightService.listSwingweights());

        model.addAttribute("tenSanPham", null);
        model.addAttribute("giaMin", null);
        model.addAttribute("giaMax", null);
        model.addAttribute("currentPage", page);

        // Xác định content view hiển thị danh sách sản phẩm
        model.addAttribute("content", "adds/ThemPhieuXuat");
        return "Home/TrangChu";
    }
    

    @GetMapping("/tim-kiem")
    public String search(
            @RequestParam(defaultValue = "0") int page,
            Model model,
            @RequestParam(required = false) Double giaMin,
            @RequestParam(required = false) Double giaMax,
            @RequestParam(required = false) String tenSanPham,
            @RequestParam(required = false) Integer selectedThuongHieu,
            @RequestParam(required = false) Integer selectedXuatXu,
            @RequestParam(required = false) Integer selectedCongNghe,
            @RequestParam(required = false) Integer selectedTrongLuong,
            @RequestParam(required = false) Integer selectedSwingWeight) {

        loadSanPhamChiTiet(model, page, tenSanPham, giaMin, giaMax, selectedThuongHieu, selectedXuatXu,
                selectedCongNghe, selectedSwingWeight, selectedTrongLuong);

        // Truyền lại giá trị lọc để giữ trạng thái khi chuyển trang
        model.addAttribute("tenSanPham", tenSanPham);
        model.addAttribute("giaMin", giaMin);
        model.addAttribute("giaMax", giaMax);
        model.addAttribute("selectedThuongHieu", selectedThuongHieu);
        model.addAttribute("selectedXuatXu", selectedXuatXu);
        model.addAttribute("selectedCongNghe", selectedCongNghe);
        model.addAttribute("selectedTrongLuong", selectedTrongLuong);
        model.addAttribute("selectedSwingWeight", selectedSwingWeight);

        // Truyền danh sách filter
        model.addAttribute("listCongNghe", congNgheService.listCongNghe());
        model.addAttribute("listTrongLuong", trongLuongService.listTrongLuongs());
        model.addAttribute("listXuatXu", xuatXuService.listXuatXus());
        model.addAttribute("listSwingWeight", swingWeightService.listSwingweights());
        model.addAttribute("listThuongHieu", thuongHieuService.listThuongHieu());
        model.addAttribute("content", "adds/ThemPhieuXuat");
        return "Home/TrangChu";
    }

    private void loadSanPhamChiTiet(Model model, int page, String tenSanPham, Double giaMin, Double giaMax,
            Integer thuongHieu, Integer xuatXu, Integer congNghe, Integer swingWeight, Integer trongLuong) {
        int size = 7;

        // Kiểm tra nếu tất cả tham số tìm kiếm đều null bằng stream
        List<Object> filters = Arrays.asList(tenSanPham, giaMin, giaMax, thuongHieu, xuatXu, congNghe, swingWeight,
                trongLuong);
        boolean isDefaultSearch = filters.stream().allMatch(Objects::isNull);

        Page<SanPhamChiTietProjection> sanPhamCtPage;

        if (isDefaultSearch) {
            // Nếu không có bộ lọc nào, lấy toàn bộ sản phẩm
            sanPhamCtPage = sanPhamChiTietService.getAllSanPhamCTDTO(page, size);
        } else {
            // Gán giá trị mặc định hợp lý
            giaMin = Optional.ofNullable(giaMin).orElse(0.0);
            giaMax = Optional.ofNullable(giaMax).orElse(Double.MAX_VALUE);
            tenSanPham = Optional.ofNullable(tenSanPham).orElse("").trim();
            thuongHieu = Optional.ofNullable(thuongHieu).orElse(0);
            xuatXu = Optional.ofNullable(xuatXu).orElse(0);
            congNghe = Optional.ofNullable(congNghe).orElse(0);
            trongLuong = Optional.ofNullable(trongLuong).orElse(0);
            swingWeight = Optional.ofNullable(swingWeight).orElse(0);

            // Truy vấn dữ liệu có điều kiện
            sanPhamCtPage = sanPhamChiTietService.searchSanPhamCt(
                    page, size, giaMin, giaMax, tenSanPham, thuongHieu, xuatXu, congNghe, swingWeight, trongLuong);
        }

        // Truyền dữ liệu vào model
        model.addAttribute("sanPhamCtPage", sanPhamCtPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPage", sanPhamCtPage.getTotalPages());
        model.addAttribute("sanPhamCt", new SanPhamChiTietDto());

        // Truyền danh sách filter
        model.addAttribute("congNghe", congNgheService.listCongNghe());
        model.addAttribute("trongLuong", trongLuongService.listTrongLuongs());
        model.addAttribute("xuatXu", xuatXuService.listXuatXus());
        model.addAttribute("swingWeight", swingWeightService.listSwingweights());
        model.addAttribute("thuongHieu", thuongHieuService.listThuongHieu());
    }
    
    
}
