package com.kky.example.libnet;


import android.os.Build;




import androidx.annotation.RequiresApi;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;

/*
 * @author Zeus
 * create at 2019/1/15 15:38
 * modify at 2019/1/15 15:38
 * modify because
 * description: TO FIT
 */
public class ResponseTransformer {

    public static <T> ObservableTransformer<Response<T>, T> handleResult() {
        return upstream -> upstream.
                onErrorResumeNext(new ErrorResumeFunction<>()).
                flatMap(new ResponseFunction<>());
    }


    private static class ErrorResumeFunction<T> implements Function<Throwable, ObservableSource<? extends Response<T>>> {

        @Override
        public ObservableSource<? extends Response<T>> apply(Throwable throwable) throws Exception{
            return Observable.error(CustomException.handleException(throwable));
        }
    }


    /**
     * 服务器返回的数据解析
     * 正常服务器返回数据和服务器可能返回的业务异常
     *
     * @param <T>
     */
    private static class ResponseFunction<T> implements Function<Response<T>, ObservableSource<T>> {
        @Override
        public ObservableSource<T> apply(Response<T> tResponse)throws Exception{
            int code = tResponse.getCode();
            String message = tResponse.getMsg();
            if (code == 200) {
                return Observable.just(tResponse.getData());
            } else {
                return Observable.error(new ApiException(code, message));
            }
        }
    }

}
