package com.laptrinhjavaweb.builder;


public class CustomerSearchBuilder {
    private String fullName;
    private String phone;
    private String email;
    private Long staffId;

    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Long getStaffId() {
        return staffId;
    }

    public CustomerSearchBuilder(Builder builder) {
        this.fullName = builder.fullName;
        this.phone = builder.phone;
        this.email = builder.email;
        this.staffId = builder.staffId;
    }

    public static class Builder {
        private String fullName;
        private String phone;
        private String email;
        private Long staffId;

        public Builder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setStaffId(Long staffId) {
            this.staffId = staffId;
            return this;
        }
           public CustomerSearchBuilder build() {
            return new CustomerSearchBuilder(this);
        }
    }

}
//    public CustomerSearchBuilder(Builder builder) {
//        fullName = builder.fullName;
//        phone = builder.phone;
//        email = builder.email;
//        staffId = builder.staffId;
//    }
//
//    public String getFullName() {
//        return fullName;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public Long getStaffId() {
//        return staffId;
//    }
//
//    public static final class Builder {
//        private String fullName;
//        private String phone;
//        private String email;
//        private Long staffId;
//
//        public Builder() {
//        }
//
//        public Builder fullName(String val) {
//            fullName = val;
//            return this;
//        }
//
//        public Builder phone(String val) {
//            phone = val;
//            return this;
//        }
//        public Builder email(String val) {
//            email = val;
//            return this;
//        }
//
//        public Builder staffId(Long val) {
//            staffId = val;
//            return this;
//        }
//
//        public CustomerSearchBuilder build() {
//            return new CustomerSearchBuilder(this);
//        }
//    }
//}
