package com.situ.shop.goods.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.situ.shop.base.PageData;
import com.situ.shop.goods.dao.ShopDao;
import com.situ.shop.goods.domain.Shop;
import com.situ.shop.goods.service.ShopService;
import com.situ.shop.util.PageUtils;
@Service
public class ShopServiceImpl implements Serializable, ShopService {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ShopDao shopDao;
	
	@Override
	public Long saveShop(HttpServletRequest request,Shop shop) {
		System.out.println(shop.getShopName());
		System.out.println(shop.getShopPicture());
		CommonsMultipartFile userFile = shop.getShopPictureFile();
		String name = userFile.getName();
		System.out.println("上传的文件的ParamName=" + name);
		String originalFilename = userFile.getOriginalFilename();
		System.out.println("上传的文件名称=" + originalFilename);
		Long size = userFile.getSize();
		System.out.println("上传文件的大小=" + size);
		// 文件的后缀
		String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
		// 写出的文件地址#此路径应该写到数据库中
		String filePath = "assets/uploads/" + Calendar.getInstance().getTimeInMillis() + suffix;
		shop.setShopPicture(filePath);
		// 项目的根路径
		String realPath = request.getServletContext().getRealPath("/");
		//要写出的文件
		File toFile = new File(realPath + filePath);
			try {
				//通过 transferTo 直接将文件写出
				userFile.transferTo(toFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		/*
		 * try { InputStream inputStream = userFile.getInputStream(); } catch
		 * (IOException e) { e.printStackTrace(); }
		 */
		shop.setCreateBy("周大大");
		shop.setCreateDate(new Date());
		return shopDao.saveShop(shop);
	}

	@Override
	public Long deleteShop(Long rowId) {
		shopDao.delete(rowId);
		return rowId;
	}

	@Override
	public List<Shop> findShop() {
		
		return shopDao.find();
	}

	@Override
	public List<Shop> findByPage(Integer pageNo, Shop searchShop) {
		// limit查询数据开始的下标
				Integer firstResult = (pageNo - 1) * 5;
				// limit查询数据 要显示的条数
				Integer maxResults = 5;
				return shopDao.findByPage(searchShop, firstResult, maxResults);
	}

	@Override
	public PageData buildPageData(Integer pageNo, Shop searchShop) {
		// 查询出数据总数
				Integer dataCount =shopDao.getCount(searchShop);
				return PageUtils.buildPageData(dataCount, pageNo);
	}

	@Override
	public Shop findShopById(Long rowId) {
		return shopDao.get(rowId);
	}

	@Override
	public Long doUpdate(Shop shop) {
		shop.setUpdateBy("zxj");
		shop.setUpdateDate(new Date());
		shopDao.update(shop);
		return shop.getRowId();
		
		
	}

	@Override
	public Boolean checkShopName(String shopName) {
				// 根据角色名称查询实例
				Shop shop = shopDao.getByName(shopName);
				// 三元表达式，如果有返回false，如果没有返回true
				Boolean bool = shop != null ? false : true;
				return bool;
	}
	

}
