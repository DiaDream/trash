/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.controller.cms.cmsadmin;

import com.xyb.trash.controller.BaseController;
import com.xyb.trash.enumeration.ArticleStatusType;
import com.xyb.trash.pojo.cms.CmsColumnInfo;
import com.xyb.trash.pojo.cms.CmsNews;
import com.xyb.trash.service.cms.CmsColumnInfoService;
import com.xyb.trash.service.cms.CmsNewsService;
import com.xyb.trash.util.commonutil.DateUtil;
import com.xyb.trash.util.commonutil.LogUtil;
import com.xyb.trash.util.commonutil.StringUtil;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by xieyunbo on 2018/6/5.
 */
@RequestMapping (value = "${server.rootpath}/news")
@Controller
public class CmsNewsController extends BaseController {

    private static final LogUtil log = new LogUtil (LoggerFactory.getLogger (CmsNewsController.class.getName()));

    //附件存储地址
    @Value("${news.attachment}")
    protected String newsAttachment;
    @Value("${site.name}")
    protected String siteName;
    //分页大小
    int limit=10;

    @Autowired
    private CmsNewsService nbNoticeArticleService;

    @Autowired
    private CmsColumnInfoService columnInfoService;
    //编辑页面
    @RequestMapping(value = "editNews")
    public String toIndex (HttpServletRequest request)
    {
        //查询栏目集合 方便选择
        Map<String,Object> buildParam=new HashMap<String,Object>();
        buildParam.put("status", "0");
        List<CmsColumnInfo> columnlist=columnInfoService.getColumnListByCondition(buildParam);
        request.setAttribute("columnlist", columnlist);
        return "/cms/admin/editNews";
    }

    @RequestMapping (value = "updateNewsPage")
    public String updateNewsPage (HttpServletRequest request)
    {
        String articleId = request.getParameter("aid");
        long aid = Long.parseLong(articleId);
        CmsNews article =nbNoticeArticleService.getNewsById(aid);
        //转义content
        article.setContent(StringEscapeUtils.unescapeHtml4(article.getContent()));
        //查询list
        Map<String,Object> buildParam=new HashMap<String,Object>();
        buildParam.put("status", "0");
        List<CmsColumnInfo> columnlist=columnInfoService.getColumnListByCondition(buildParam);
        request.setAttribute("columnlist", columnlist);
        request.setAttribute("article", article);
        return "/cms/admin/updateNews";
    }

    @RequestMapping (value = "newsList")
    public String tonewsList (HttpServletRequest request)
    {
        return "/cms/admin/newsList";
    }
    //新闻上传
    @RequestMapping (value = "addNews")
    public String addNews (MultipartFile titleimage, CmsNews  nbNoticeArticle)
    {

        String  fileName="-1";
        if(titleimage!=null&&titleimage.getSize()>0){
            fileName=uploadFile(titleimage);
        }
        if(!"-1".equals(fileName)){
            nbNoticeArticle.setFilePath(fileName);
        }
        //发布日期
        nbNoticeArticle.setReleaseTime(DateUtil.formatStringToDate(nbNoticeArticle.getReleaseTimeStr(), "yyyy/MM/dd HH:mm"));
        //创建时间
        nbNoticeArticle.setCreateTime(new Date());
        //创建人 后期从session 中获取
        nbNoticeArticle.setCreatorId(1l);
        //点击数
        nbNoticeArticle.setClicktotal(0);
        //文章状态
        nbNoticeArticle.setStatus(ArticleStatusType.NORMAL.getValue());
        //发布状态
        nbNoticeArticle.setCheckStatus(ArticleStatusType.CREATE.getValue());
        //是否推荐置顶
        nbNoticeArticle.setImportant(ArticleStatusType.UNRECOMMEND.getValue());
        //如果没有来源 默认本站
        if(StringUtil.isEmpty(nbNoticeArticle.getOrigin())){
            nbNoticeArticle.setOrigin(siteName);
        }
        if(StringUtil.isEmpty(nbNoticeArticle.getOuturl())){
            nbNoticeArticle.setOuturl(serviceDomain);
        }
        //如果没有来源链接 默认本站
        log.infoLog(fileName);
        int flag=nbNoticeArticleService.addNews(nbNoticeArticle);
        return "redirect:/cms/admin/index";
    }
    //新闻修改
    @RequestMapping (value = "updateNews")
    @ResponseBody
    public String updateNews (MultipartFile titleimage,CmsNews  nbNoticeArticle)
    {
        int flag=nbNoticeArticleService.updateNews(nbNoticeArticle);
        if(flag>0){
            return "success";
        }else{
            return "failed";
        }
    }
    //分页搜索查询所有新闻
    @RequestMapping (value = "getNewsListByCondition")
    @ResponseBody
    public Map<String,Object> getNewsListByCondition(HttpServletRequest request)
    {	//返回参数
        Map<String,Object> resultMap=new HashMap<String,Object>();

        Map<String,Object> buildParam=new HashMap<String,Object>();
        //获得参数
        String curPageStr = request.getParameter ("curPage");
        String title = request.getParameter ("title");
        String author = request.getParameter ("author");
        String startStr=request.getParameter ("start");
        String endStr=request.getParameter ("end");
        buildParam.put ("startTime", DateUtil.formatStringToDate(startStr, "MM/dd/yyyy"));
        buildParam.put ("endTime", DateUtil.formatStringToDate(endStr, "MM/dd/yyyy"));
        buildParam.put ("title", "%" + title + "%");
        buildParam.put ("author", "%" + author + "%");
        // 分页参数
        int offset = 0;
        // 当前页
        // 默认当前页为1
        int curPage = 1;
        // 获取offset值，从哪条记录开始
        if (null != curPageStr && !"".equals (curPageStr))
        {
            curPage = Integer.parseInt (curPageStr);
            offset = (curPage - 1) * limit;
        }

        List<CmsNews> newsList=nbNoticeArticleService.getNewsList (buildParam, offset, limit);

        // 获取总记录数
        int total = nbNoticeArticleService.countNews(buildParam);
        int totalPage = (int) Math.floor ((total + limit - 1) / limit);

        resultMap.put("newsList", newsList);
        resultMap.put("total", total);
        resultMap.put("totalPage", totalPage);
        resultMap.put("curPage", curPage);
        return resultMap;
    }
    //新闻删除

    //所有栏目查询


    //附件上传
    @RequestMapping (value = "uploadAttachment")
    @ResponseBody
    public String uploadAttachment(HttpServletRequest request) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        /** 页面控件的文件流* */
        MultipartFile multipartFile = multipartRequest.getFile("file");
        String  fileName="-1";
        if(multipartFile!=null){
            fileName = uploadFile(multipartFile);
        }

        log.infoLog(fileName);
        //insertDate(fileName);
        return fileName;
    }

    //文件上传
    public String uploadFile(MultipartFile multipartFile)
    {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");
        /** 构建文件保存的目录* */
        String logoPathDir = "/attachment/"
                + dateformat.format(new Date());
        /** 得到文件保存目录的真实路径* */
        /** 根据真实路径创建目录* */
        File logoSaveFile = new File(newsAttachment);
        if (!logoSaveFile.exists())
            logoSaveFile.mkdirs();
        /** 获取文件的后缀* */
        String suffix = multipartFile.getOriginalFilename().substring(
                multipartFile.getOriginalFilename().lastIndexOf("."));
        /** 使用UUID生成文件名称* */
        String logImageName = UUID.randomUUID().toString() + suffix;// 构建文件名称
        /** 拼成完整的文件保存路径加文件* */
        String fileName = newsAttachment + File.separator + logImageName;
        File file = new File(fileName);
        try {
            multipartFile.transferTo(file);
            return fileName;
        } catch (IllegalStateException e) {
            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }

        return null;
    }
    //构建参数方法
    public Map<String,Object> buildParam(String...param){
        //查询参数
        Map<String,Object> map=new HashMap<String,Object>();
        for (String sp : param) {
            if(!StringUtil.isEmpty(sp)){
                map.put (sp, "%" + sp + "%");
            }
        }
        return map;
    }
}
