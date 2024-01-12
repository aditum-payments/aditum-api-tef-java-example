package com.tef.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseResponse {

    private List<AditumApiError> errors = null;

    private Boolean success = null;

    public List<AditumApiError> getErrors() {
        return errors;
    }

    public void setErrors(List<AditumApiError> errors) {
        this.errors = errors;
    }

    public void addError(AditumApiError error) {
        if (this.errors == null) {
            this.errors = new ArrayList<>();
        }

        this.errors.add(error);
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
