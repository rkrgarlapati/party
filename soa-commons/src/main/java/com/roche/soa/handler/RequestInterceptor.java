package com.roche.soa.handler;

import com.roche.soa.constants.ApiErrorConstants;
import com.roche.soa.exception.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		ZonedDateTime currentTimeUTC = ZonedDateTime.now(ZoneOffset.UTC);
		logger.info("Request URL: {} Start Time: {}", request.getRequestURL().toString(), currentTimeUTC);
		request.setAttribute("startTime", currentTimeUTC);

        Map<String, String[]> parameters = request.getParameterMap();

        validateRequestParameters(parameters);

		return true;

	}

    private void validateRequestParameters(Map<String, String[]> parameters) {

        /*if(parameters.containsKey("page")){
            String page = parameters.get("page")[0];
            if(!NumberUtils.isParsable(page) || NumberUtils.toInt(page)<0 || !(NumberUtils.isDigits(page)) || (NumberUtils.toDouble(page) > 1000000)) {
                logger.error("Invalid Page Numner : {} ", page);
                throw new BadRequestException(ApiErrorConstants.ERROR_PAGINATION_INVALID_PAGE, ApiErrorConstants.ERROR_PAGINATION_INVALID_PAGE_MSG);
            }
        }

        if(parameters.containsKey("size")){
            String size = parameters.get("size")[0];
            if(!NumberUtils.isParsable(size) || NumberUtils.toInt(size)<1 || !(NumberUtils.isDigits(size)) ||(NumberUtils.toDouble(size) > 50)){
                logger.error("Invalid Size : {} ", size);
                throw new BadRequestException(ApiErrorConstants.ERROR_PAGINATION_INVALID_SIZE, ApiErrorConstants.ERROR_PAGINATION_INVALID_SIZE_MSG);
            }
        }*/
    }

    @Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		ZonedDateTime startTime = (ZonedDateTime) request.getAttribute("startTime");
		ZonedDateTime currentTimeUTC = ZonedDateTime.now(ZoneOffset.UTC);

		long seconds = ChronoUnit.SECONDS.between(startTime, currentTimeUTC);
		logger.info("Request URL: {} End Time: {} Time Taken Seconds: {} ", request.getRequestURL().toString(), currentTimeUTC, seconds);
	}
}