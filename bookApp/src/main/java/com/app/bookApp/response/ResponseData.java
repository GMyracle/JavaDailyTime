package com.app.bookApp.response;


import com.app.bookApp.dataaccess.BookEntity;
import com.app.bookApp.response.BaseObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class ResponseData<T> extends BaseObject {


    // Dữ liệu của phản hồi
    private T data;

    // Mã trạng thái HTTP của phản hồi
    @ApiModelProperty(notes = "Status code")
    private int status;

    // Lỗi (nếu có) của phản hồi
    @ApiModelProperty(notes = "Error content")
    private String error;

    // ID tin nhắn của khách hàng
    @ApiModelProperty(notes = "client message id")
    private String clientMessageId;

    // Đường dẫn của yêu cầu gửi phản hồi
    private String path;

    // Phương thức tạo một đối tượng phản hồi thành công
    public static <T> ResponseData<T> ok(String clientMessageId, String path) {
        return restResult(null, HttpStatus.OK, null, clientMessageId, path);
    }

    // Phương thức tạo một đối tượng phản hồi thành công với yêu cầu nội bộ
    public static <T> ResponseData<T> ok(T data,String clientMessageId, String path) {
        return restResult(null, HttpStatus.OK, null, clientMessageId, path);
    }

    // Phương thức tạo một đối tượng phản hồi thất bại
    public static <T> ResponseData<T> failed(HttpStatus status, String error, String clientMessageId, String path) {
        return restResult(null, status, error, clientMessageId, path);
    }

    // Phương thức tạo một đối tượng phản hồi thất bại với dữ liệu cụ thể
    public static <T> ResponseData<T> failed(T data, HttpStatus status, String error, String clientMessageId, String path) {
        return restResult(data, status, error, clientMessageId, path);
    }

    // Phương thức tạo đối tượng phản hồi
    private static <T> ResponseData<T> restResult(T data, HttpStatus status, String error, String clientMessageId, String path) {
        ResponseData<T> apiResult = new ResponseData<>();
        apiResult.setStatus(status.value());
        apiResult.setError(status.getReasonPhrase());
        apiResult.setClientMessageId(clientMessageId);
        apiResult.setPath(path);
        apiResult.setData(data);
        return apiResult;
    }


}

