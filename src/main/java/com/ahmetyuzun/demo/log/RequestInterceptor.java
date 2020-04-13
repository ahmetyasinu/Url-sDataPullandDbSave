package com.ahmetyuzun.demo.log;

import com.ahmetyuzun.demo.entity.Report;
import com.ahmetyuzun.demo.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Api ye gonderilen istekleri interceptor ile Report tablosunda kayit altina aldik.
 */
@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestInterceptor.class);
    private final ReportService reportService;

    public RequestInterceptor(ReportService reportService) {
        this.reportService = reportService;
    }

    /**
     * @param request gelen isteklerin bilgilerini icerir.
     * @param response giden cevapların bilgilerini icerir.
     * @param handler islem bilgilerini icerir.
     * @return dönüs degerimize islem devam etsin etmesin diye karar verir.
     * @throws Exception bir hata gelirse exception firlatir.
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpServletRequest requestCacheWrapperObject
                = new ContentCachingRequestWrapper(request);
        requestCacheWrapperObject.getParameterMap();

        LOGGER.info("\n\n\n----------------LogInterceptor PreHandle (Start)--------------------------");
        LOGGER.info(request.getRemoteAddr()
                + " accessed resource " + request.getRequestURI() + " @ " + getCurrentTime() + "Method" + request.getMethod());
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        LOGGER.info("----------------LogInterceptor PreHandle(End)--------------------------");
        Report report = new Report();
        report.setIpAddress(request.getRemoteAddr());
        report.setEndPoint(request.getRequestURL().toString());
        report.setHttpType(request.getMethod());
        report.setTime(startTime);
        reportService.save(report);

//        if(request.getRemoteAddr().startsWith("192")) {
//            response.sendRedirect("/auth-failed"); //redirect to default
//            return false;
//        }

        return true;

    }

    /**
     *
     * @param request gelen isteklerin bilgilerini icerir.
     * @param response giden cevapların bilgilerini icerir.
     * @param handler islem bilgilerini icerir.
     * @param ex exceptionları icerir.
     */
    @Override
    public void afterCompletion(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            Exception ex) {
        //
    }

    /**
     * zamanı getirir.
     * @return
     */
    private String getCurrentTime() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy 'at' hh:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return formatter.format(calendar.getTime());
    }


}
