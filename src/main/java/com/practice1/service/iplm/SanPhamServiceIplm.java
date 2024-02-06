package com.practice1.service.iplm;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.util.ArrayBuilders.BooleanBuilder;
import com.practice1.entities.SanPham;
import com.practice1.repository.SanPhamRepository;
import com.practice1.service.SanPhamService;
@Service
public class SanPhamServiceIplm implements SanPhamService{


	@Autowired
	private SanPhamRepository spRepo;
	
	 @Override  
	  public void saveSp(SanPham sp) {  
	    spRepo.save(sp);
	  }  
	
	@Override
	public SanPham update(Integer id, SanPham sp) {
		
		return null;
	}



	@Override
	public void deleteSp(SanPham sp) {
		spRepo.delete(sp);
	}

	@Override
	public SanPham createSanPham(SanPham sp) {
		return spRepo.save(sp);
	}

	@Override
	public List<SanPham> getAllsp() {
		
		return (List<SanPham>) spRepo.findAll();
	}



	@Override
	public Optional<SanPham> findSanPhamById(int id) {
		return spRepo.findById(id);
	}

	@Override
	public void deleteByid(int id) {
		spRepo.deleteById(id);
		
	}


	@Override
	public Page<SanPham> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -  1, pageSize);
		return spRepo.findAll(pageable);
	}

	@Override
	public Optional<SanPham> findOneSanPhamById(int id) {
		return spRepo.findById(id);
	}

	@Override
	public List<SanPham> SaveAll(List<SanPham> sps) {
		
		return (List<SanPham>) spRepo.saveAll(sps);
	}

//	@Override
//	public SanPham searchProduct(int id) {
//		SanPham product = spRepo.searchProduct(id);
//		return product;
//	}

	@Override
	public List<SanPham> getAllSP() {
		
		return (List<SanPham>) spRepo.findAll();
	}


	@Override
	public SanPham findSpById(int id) {
		SanPham product = spRepo.FindSPById(id);
		return product;
	}

	@Override
	public List<SanPham> findSpByText(String keyWord) {
		List<SanPham> listProduct = spRepo.searchSP(keyWord);
		return listProduct;
	}




	
	

}
