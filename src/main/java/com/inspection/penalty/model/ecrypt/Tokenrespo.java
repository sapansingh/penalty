package com.inspection.penalty.model.ecrypt;

public class Tokenrespo {

    private int accessTokenExpiryTime;
    private String jwtToken;
    private String message;
    private int refreshTokenExpiryTime;
    private boolean status;
    private String refreshToken;


    public int getAccessTokenExpiryTime() {
        return this.accessTokenExpiryTime;
    }

    public void setAccessTokenExpiryTime(int accessTokenExpiryTime) {
        this.accessTokenExpiryTime = accessTokenExpiryTime;
    }

    public String getJwtToken() {
        return this.jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getRefreshTokenExpiryTime() {
        return this.refreshTokenExpiryTime;
    }

    public void setRefreshTokenExpiryTime(int refreshTokenExpiryTime) {
        this.refreshTokenExpiryTime = refreshTokenExpiryTime;
    }

    public boolean isStatus() {
        return this.status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }


    @Override
    public String toString() {
        return "{" +
            " accessTokenExpiryTime='" + getAccessTokenExpiryTime() + "'" +
            ", jwtToken='" + getJwtToken() + "'" +
            ", message='" + getMessage() + "'" +
            ", refreshTokenExpiryTime='" + getRefreshTokenExpiryTime() + "'" +
            ", status='" + isStatus() + "'" +
            ", refreshToken='" + getRefreshToken() + "'" +
            "}";
    }

    
}
