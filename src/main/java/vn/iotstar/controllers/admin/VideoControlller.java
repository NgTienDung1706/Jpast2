	package vn.iotstar.controllers.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.Video;
import vn.iotstar.service.impl.CategoryService;
import vn.iotstar.service.impl.VideoService;
import vn.iotstar.util.Constant;
@MultipartConfig(fileSizeThreshold = 1024 * 1024,

maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns = { "/admin/video/insert", "/admin/video/edit", "/admin/video/delete" })
public class VideoControlller extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VideoService videoService = new VideoService();
    private CategoryService categoryService = new CategoryService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String url = req.getRequestURI();
        
        if (url.contains("/admin/video/edit")) {
            // Lấy thông tin video để chỉnh sửa
            int id = Integer.parseInt(req.getParameter("id"));
            Video video = videoService.findById(id);
            req.setAttribute("video", video);
            req.setAttribute("categories", categoryService.findAll());
            req.getRequestDispatcher("/views/admin/Video.jsp").forward(req, resp);
        } else if (url.contains("/admin/video/delete")) {
            // Xóa video
            int id = Integer.parseInt(req.getParameter("id"));
            try {
				videoService.delete(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
            resp.sendRedirect(req.getContextPath() + "/admin/videos");
        } else {
            // Danh sách video
            List<Video> videos = videoService.findAll();
            req.setAttribute("videos", videos);
            req.setAttribute("categories", categoryService.findAll());
            req.getRequestDispatcher("/views/admin/Video.jsp").forward(req, resp);
        }
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String videoid = req.getParameter("videoid");
        String title = req.getParameter("title");
        int viewCount = Integer.parseInt(req.getParameter("viewCount"));
        int categoryId = Integer.parseInt(req.getParameter("categoryid"));
        String description = req.getParameter("description");
        int avtive = Integer.parseInt(req.getParameter("active"));
        // Lưu hình ảnh
        Part filePart = req.getPart("image");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String imagePath = Constant.UPLOAD_DIRECTORY + "/" + fileName;
        File uploadDir = new File(Constant.UPLOAD_DIRECTORY);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        filePart.write(imagePath);

        // Tạo đối tượng video
        Video video = new Video();
        video.setVideoId(videoid);
        video.setTitle(title);
        video.setViews(viewCount);
        video.setDescription(description);
        video.setActive(avtive);
        video.setPoster(fileName);
        
        // Gán danh mục
        Category category = categoryService.findById(categoryId);
        video.setCategory(category);
        
        // Thêm video
        videoService.insert(video);
     // Tải lại danh sách video và danh sách danh mục để hiển thị
        List<Video> videos = videoService.findAll();
        List<Category> categories = categoryService.findAll(); // Lấy danh sách danh mục

        // Đưa dữ liệu vào request
        req.setAttribute("videos", videos);
        req.setAttribute("categories", categories);
        // Chuyển hướng sau khi thêm thành công
//        resp.sendRedirect(req.getContextPath() + "/admin/videos");
        req.getRequestDispatcher("/views/admin/Video.jsp").forward(req, resp);
	}
}
