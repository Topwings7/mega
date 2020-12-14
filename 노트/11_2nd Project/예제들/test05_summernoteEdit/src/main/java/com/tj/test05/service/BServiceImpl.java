package com.tj.test05.service;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.tj.test05.dao.BDao;
import com.tj.test05.dto.B;
@Service
public class BServiceImpl implements BService {
	@Autowired
	private BDao bDao;
	private String backupPath = "C:\\bit\\source\\11._2ndProject\\2ndProject_sts3\\test05_summernoteEdit\\src\\main\\webapp\\fileUp\\"; 
	@Override
	public List<B> list(B b, String pageNum, Model model) {
		Paging paging = new Paging(bDao.cnt(b), pageNum);
		b.setStartRow(paging.getStartRow());
		b.setEndRow(paging.getEndRow());
		model.addAttribute("paging", paging);
		return bDao.list(b);
	}
	@Override
	public int write(MultipartHttpServletRequest mRequest, B b, Model model) {
		String uploadPath = mRequest.getRealPath("fileUp/");
		Iterator<String> params = mRequest.getFileNames();
		String filename = "";
		while(params.hasNext()) {
			String param = params.next();
			System.out.println("파라미터 이름  : "+param);
			MultipartFile mFile = mRequest.getFile(param);
			filename = mFile.getOriginalFilename();
			System.out.println("파라미터 이름 : "+ param +"/ 파일이름 : ");
			System.out.println(filename.equals("")? "빈스트링":filename);
			if(filename!=null && !filename.equals("")) {
				if(new File(uploadPath + filename).exists()) {
					filename = System.currentTimeMillis() + "_" + filename;
				}
				try {
					mFile.transferTo(new File(uploadPath + filename));
					System.out.println("서버파일 : " + uploadPath + filename);
					System.out.println("서버파일 : " + backupPath + filename);
					int result = filecopy(uploadPath + filename, backupPath + filename);
					System.out.println(result == 1? "파일 복사 성공" : "파일 복사 실패");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				System.out.println("파일 첨부를 안 했네");
			}
		}//if
		b.setBfile(filename);
		System.out.println("수정할 글 : "+b);
		int result = 0;
		try {
			result = bDao.write(b);
			model.addAttribute("successMsg", "글 쓰기가 완료되었습니다");
		}catch (Exception e) {
			model.addAttribute("failMsg", "글 쓰기에 실패했습니다");
		}
		return result;
	}

	@Override
	public B detail(int bno) {
		return bDao.detail(bno);
	}

	@Override
	public int update(MultipartHttpServletRequest mRequest, Model model) {
		String uploadPath = mRequest.getRealPath("fileUp/");
		Iterator<String> params = mRequest.getFileNames();
		String filename = "";
		while(params.hasNext()) {
			String param = params.next();
			System.out.println("파라미터 이름  : "+param);
			MultipartFile mFile = mRequest.getFile(param);
			filename = mFile.getOriginalFilename();
			System.out.println("파라미터 이름 : "+ param +"/ 파일이름 : ");
			System.out.println(filename.equals("")? "빈스트링":filename);
			if(filename!=null && !filename.equals("")) {
				if(new File(uploadPath + filename).exists()) {
					filename = System.currentTimeMillis() + "_" + filename;
				}
				try {
					mFile.transferTo(new File(uploadPath + filename));
					System.out.println("서버파일 : " + uploadPath + filename);
					System.out.println("서버파일 : " + backupPath + filename);
					int result = filecopy(uploadPath + filename, backupPath + filename);
					System.out.println(result == 1? "파일 복사 성공" : "파일 복사 실패");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				System.out.println("파일 첨부를 안 했네");
			}
		}//if
		int bno = Integer.parseInt(mRequest.getParameter("bno"));
		String btitle = mRequest.getParameter("btitle");
		String bcontent = mRequest.getParameter("bcontent");
		B b = new B(bno, btitle, bcontent, filename);
		System.out.println("수정할 글 : "+b);
		int result = 0;
		try {
			result = bDao.update(b);
			model.addAttribute("successMsg", "글 수정이 완료되었습니다");
		}catch (Exception e) {
			model.addAttribute("failMsg", "글 수정에 실패했습니다");
		}
		return result;
	}

	@Override
	public int delete(int bno, Model model) {
		int result = 0 ;
		try {
			result = bDao.delete(bno);
			model.addAttribute("successMsg", "글 삭제가 완료되었습니다");
		}catch (Exception e) {
			model.addAttribute("failMsg", "글 삭제에 실패했습니다");
		}
		return result;
	}

	private int filecopy(String serverFile, String backupFile) {
		int isCopy = 0;
		FileInputStream is = null;
		FileOutputStream os = null;
		try {
			is = new FileInputStream(serverFile);
			os = new FileOutputStream(backupFile);
			File sFile = new File(serverFile);
			byte[] buff = new byte[(int)sFile.length()];
			while(true) {
				int nRead = is.read(buff);
				if(nRead == -1) {
					break;
				}
				os.write(buff, 0, nRead);
			}
			isCopy = 1;
		} catch (FileNotFoundException e) {
			System.out.println("복사 예외0 : "+e.getMessage());
		} catch (IOException e) {
			System.out.println("복사 예외1 : "+e.getMessage());
		} finally {
			try {
				if(os!=null) {
					os.close();
				}
				if(is!=null) {
					is.close();
				}
			}catch (Exception e) {
			}
		}
		return isCopy;
	}
}
