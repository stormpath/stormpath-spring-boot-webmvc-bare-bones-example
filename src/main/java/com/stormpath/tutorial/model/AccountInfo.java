package com.stormpath.tutorial.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.stormpath.sdk.account.AccountStatus;
import com.stormpath.sdk.directory.CustomData;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountInfo {

    private String href, email, givenName, middleName, surName, fullName;
    private AccountStatus accountStatus;
    private CustomData customData;

    private RequestStatus requestStatus;
    private String requestMessage;

    enum RequestStatus {
        SUCCESS, FAILURE
    }

    public AccountInfo(Exception e) {

        this.requestStatus = RequestStatus.FAILURE;
        this.requestMessage = e.getMessage();
    }

    public AccountInfo(
        String href, String email,
        String givenName, String middleName, String surName, String fullName,
        AccountStatus accountStatus, CustomData customData
    ) {
        this.href = href;
        this.email = email;
        this.givenName = givenName;
        this.middleName = middleName;
        this.surName = surName;
        this.fullName = fullName;
        this.accountStatus = accountStatus;
        this.customData = customData;

        this.requestStatus = RequestStatus.SUCCESS;
        this.requestMessage = "Successfully retrieved account";
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public CustomData getCustomData() {
        return customData;
    }

    public void setCustomData(CustomData customData) {
        this.customData = customData;
    }

    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getRequestMessage() {
        return requestMessage;
    }

    public void setRequestMessage(String requestMessage) {
        this.requestMessage = requestMessage;
    }
}
