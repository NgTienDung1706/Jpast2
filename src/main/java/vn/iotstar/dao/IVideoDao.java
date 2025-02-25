package vn.iotstar.dao;

import java.util.List;


import vn.iotstar.entity.Video;

public interface IVideoDao {
	int count();
	List<Video> findAll(int page, int pagesize);
	List<Video> findAll();
	Video findById(int id);
	void delete(int videoid) throws Exception;
	void update(Video video);
	void insert(Video video);
}
