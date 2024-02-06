package com.practice1.service;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.practice1.dto.SanPhamDto;
import com.practice1.entities.SanPham;
public interface SanPhamService {
	
	public SanPham update(Integer id, SanPham sp);
	public Optional<SanPham> findSanPhamById(int id);
	public List<SanPham> SaveAll(List<SanPham> sps);
	Optional<SanPham> findOneSanPhamById(int id);
	void deleteSp(SanPham sp);
	public SanPham createSanPham(SanPham sp);
	public List<SanPham> getAllsp();
	void saveSp(SanPham sp);
	void deleteByid(int id);
	 Page <SanPham> findPaginated(int pageNo, int pageSize);
	 List<SanPham> getAllSP();
	 SanPham findSpById(int id);
	 List<SanPham> findSpByText(String text);

}
