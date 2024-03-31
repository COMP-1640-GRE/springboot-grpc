package com.example.grpctest1.model.enumarate;

import org.springframework.lang.Nullable;

public enum ResponseCode {
    BAD_REQUEST(900000000, Series.CLIENT_ERROR),
    NOT_FOUND(900000001, Series.CLIENT_ERROR),
    UNAUTHORIZED(900000002, Series.CLIENT_ERROR),
    FORBIDDEN(900000003, Series.CLIENT_ERROR),;

    private final int value;
    private final Series series;

    public static ResponseCode valueOf(int value) {
        ResponseCode[] var1 = values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            ResponseCode responseCode = var1[var3];
            if (responseCode.getValue() == value) {
                return responseCode;
            }
        }

        return null;
    }

    public static boolean equalCodeAndResponseCode(Integer code, ResponseCode responseCode) {
        if (code != null && responseCode != null) {
            ResponseCode responseCode1 = valueOf(code);
            return responseCode1 == responseCode;
        } else {
            return true;
        }
    }

    private ResponseCode(int value, Series series) {
        this.value = value;
        this.series = series;
    }

    public int getValue() {
        return this.value;
    }

    public Series getSeries() {
        return this.series;
    }

    public enum Series {
        SUCCESSFUL(0),
        CLIENT_ERROR(1);

        private final int value;

        private Series(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }

        @Nullable
        public static Series resolve(int statusCode) {
            int seriesCode = statusCode / 100;
            Series[] var2 = values();
            int var3 = var2.length;

            for (int var4 = 0; var4 < var3; ++var4) {
                Series series = var2[var4];
                if (series.value == seriesCode) {
                    return series;
                }
            }

            return null;
        }
    }
}
