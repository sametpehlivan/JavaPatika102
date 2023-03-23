package com.patika.model;

public enum Role
{
        OPERATOR("operator"){
            @Override
            public boolean isOperator() {return true;}
        },
        EDUCATOR("educator"){
            @Override
            public boolean isEducator() {return true;}
        },
        STUDENT("student"){
            @Override
            public boolean isStudent(){return true;}
        };
        public boolean isOperator() {return false;}

        public boolean isEducator() {return false;}

        public boolean isStudent(){return false;}
        private final String role;
        Role(String role)
        {
            this.role = role.trim().toLowerCase();
        }
        public String getRole() {return role;}
        public static Role findByValue(String value) {
            Role result = null;
            for (Role role : values()) {
                if (role.getRole().equals(value.trim().toLowerCase())) {
                    result = role;
                    break;
                }
            }
            return result;
        }
}
