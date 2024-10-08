package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.dao.impl.VideoDao;
import vn.iotstar.entity.Video;
import vn.iotstar.service.IVideoService;
import vn.iotstar.dao.IVideoDao;

public class VideoService implements IVideoService{
	IVideoDao videodao = new VideoDao();
	@Override
	public int count() {
		return videodao.count();
	}

	@Override
	public List<Video> findAll(int page, int pagesize) {
		return videodao.findAll(page, pagesize);
	}

	@Override
	public List<Video> findAll() {
		return videodao.findAll();
	}

	@Override
	public Video findById(int id) {
		return videodao.findById(id);
	}

	@Override
	public void delete(int videoid) throws Exception {
		videodao.delete(videoid);
	}

	@Override
	public void update(Video video) {
		videodao.update(video);
	}

	@Override
	public void insert(Video video) {
		videodao.insert(video);
	}

}
