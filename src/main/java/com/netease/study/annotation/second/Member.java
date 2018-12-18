package com.netease.study.annotation.second;


@DBTable(name = "member")
public class Member {
    @SQLString(20)
    public String firstName;
    @SQLString(50)
    public String lastName;
    @SQLInteger
    public Integer age;
    @SQLString(value=30,constraints=@Constraints(primaryKey=true))
    public String handle;
    public static int memberCount;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public static int getMemberCount() {
        return memberCount;
    }

    public static void setMemberCount(int memberCount) {
        Member.memberCount = memberCount;
    }
}
