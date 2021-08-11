package com.behsa.smsGw;


import org.springframework.http.HttpStatus;

public class ResponseDto<T> {
        private T data;

        public ResponseDto(T data, int ok200) {
            this.data = data;
        }

        public ResponseDto(HttpStatus forbidden) {
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }


