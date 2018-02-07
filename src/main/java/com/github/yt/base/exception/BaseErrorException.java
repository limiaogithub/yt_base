package com.github.yt.base.exception;

import java.text.MessageFormat;


/**
 * Created with IntelliJ IDEA.
 * 以下我们对是“意外事件”和“错误”的理解
 * <p>
 * <p>
 * 异常条件	                        意外事件	                    错误
 * <p>
 * 认为是（Is considered to be）	    设计的一部分	                难以应付的意外
 * 预期发生（Is expected to happen）	有规律但很少发生	            从不
 * 谁来处理（Who cares about it）	    调用方法的上游代码	            需要修复此问题的人员
 * 实例（Examples）	                另一种返回模式	                编程缺陷，硬件故障，配置错误，文件丢失，服务器无法使用
 * 最佳映射（Best Mapping）	        已检查异常	                未检查异常
 */
public class BaseErrorException extends RuntimeException {

    private static final long serialVersionUID = 8686960428281101221L;
    private String errorCode;
    private ExceptionBody exceptionBody;

    public BaseErrorException(String refBizId, String logContent, Exception e) {
    }

    /** @deprecated */
    @Deprecated
    public BaseErrorException(ExceptionBody exceptionBody) {
        super(exceptionBody.getMessage());
        this.exceptionBody = exceptionBody;
        this.errorCode = exceptionBody.getCode();
    }

    /** @deprecated */
    @Deprecated
    public BaseErrorException(ExceptionBody exceptionBody, Throwable cause) {
        super(exceptionBody.getMessage(), cause);
        this.exceptionBody = exceptionBody;
        this.errorCode = exceptionBody.getCode();
    }

    public BaseErrorException() {
    }

    public BaseErrorException(Throwable cause) {
        super(cause.getMessage(), cause);
    }

    public BaseErrorException(String message) {
        super(message);
    }

    public BaseErrorException(String message, Object... objects) {
        super(MessageFormat.format(message, objects));
    }

    public BaseErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseErrorException(String message, Throwable cause, Object... objects) {
        super(MessageFormat.format(message, objects), cause);
    }
}
