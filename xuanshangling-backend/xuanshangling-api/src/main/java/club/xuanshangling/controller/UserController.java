package club.xuanshangling.controller;

import club.xuanshangling.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: wangcf
 * @Date: 2019/6/20 22:29
 * @Description ${description}
 */
@RestController
@Api(value = "用户业务相关的接口", tags = "用户业务controller")
@RequestMapping("/user")
public class UserController extends BasicController {

    @PostMapping("/uploadFace")
    @ApiOperation(value = "上传头像", notes = "上传用户头像")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "String", paramType = "query")
    public JsonResult uploadFace(String userId, @RequestParam("file") MultipartFile[] files) {
        //设置文件在服务器上的命名空间 格式：当前项目/files/userid/face/XXX.JPG
        //String fileSpacePath = "E:/wx/xuanshangling/xuanshangling-backend/files";
        String fileSpacePath = "files";
        if (StringUtils.isBlank(userId))
            return JsonResult.errorMsg("用户id不能为空");
        if (files == null || files.length <= 0)
            return JsonResult.errorMsg("文件错误");
        String fileName = files[0].getOriginalFilename();
        if (StringUtils.isBlank(fileName))
            return JsonResult.errorMsg("文件错误");

        //设置文件保存到数据库中的相对位置
        String dbPath = "/" + userId + "/face/" + fileName;
        //设置文件上传到服务器的位置
        String serverPath = fileSpacePath + dbPath;

        //定义输入流和输出流
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            File outFile = new File(serverPath);
            //文件夹不存在则创建
            if (outFile.getParentFile() == null || !outFile.getParentFile().isDirectory())
                outFile.getParentFile().mkdirs();
            //写入文件到服务器
            fileOutputStream = new FileOutputStream(outFile);
            inputStream = files[0].getInputStream();
            IOUtils.copy(inputStream, fileOutputStream);

            //将文件相对路径保存到数据库中


        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.errorMsg("上传出错");
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    fileOutputStream = null;
                }
            }
        }

        return JsonResult.ok(dbPath);

    }
}
