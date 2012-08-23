package cn.net.tongfang.web.servlet;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.net.tongfang.framework.security.demo.service.TaxempDetail;
import cn.net.tongfang.framework.security.vo.OnlinePhoto;
import cn.net.tongfang.web.service.OnlineTakePhotoService;

public class OnLineTakePhotoServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");   
        response.setHeader("Pragma", "No-cache");   
        response.setHeader("Cache-Control", "no-cache");   
        response.setDateHeader("Expires", 0);   
  
        String bitmap_data = request.getParameter("bitmap_data");   
        int width = Integer.parseInt(request.getParameter("width"));   
        int height = Integer.parseInt(request.getParameter("height"));   
        BufferedImage img = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);   
		try {   
            int w = width;   
            int h = height;   
            int[] pixels = new int[w * h];   
            String[] m_tempPics = bitmap_data.split(",");   
            for (int x = 0; x < w; x++) {   
                for (int y = 0; y < h; y++) {   
                    long pic_argb = (long) Long.parseLong(m_tempPics[x * h + y]);   
                    int a = (int) (pic_argb >> 24 & 0xFF);   
                    int r = (int) (pic_argb >> 16 & 0xFF);   
                    int g = (int) (pic_argb >> 8 & 0xFF);   
                    int b = (int) (pic_argb & 0xFF);   
                    pixels[y * w + x] = new Color(r, g, b, a).getRGB();   
                }   
            }   
            img.setRGB(0, 0, w, h, pixels, 0, w);   
            img.flush();   
            ByteArrayOutputStream bao = new ByteArrayOutputStream();   
            ImageIO.write(img, "jpg", bao);   
            byte[] data = bao.toByteArray();  
            String filePath = request.getRealPath("/headPicture");
            //判断路径是否存在,若不存在则创建路径
            File upDir = new File(filePath);
            if (!upDir.exists())
            {
                upDir.mkdir();
            }
            //生成随机文件名
            String saveName = UUID.randomUUID().toString(); ;
            String fileName = saveName + ".jpg";
            //写图片
            File f = new File(filePath+"\\" + fileName);
    		DataOutputStream dos = new DataOutputStream(new FileOutputStream(f));
    		dos.write(data);
    		dos.flush();
    		dos.close();
    		response.setContentType("text/xml");   
            response.getWriter().write("/headPicture/" + fileName);
            TaxempDetail user = cn.net.tongfang.framework.security.SecurityManager.currentOperator();
            OnlineTakePhotoService.save(user.getUsername(), fileName);
        }
        catch(Exception ex)
        {
        	response.setContentType("text/xml");   
            response.getWriter().write("保存失败");   
        }
	}

}
