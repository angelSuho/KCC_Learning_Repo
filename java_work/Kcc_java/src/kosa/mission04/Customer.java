package kosa.mission04;

public class Customer {

    private String nickname;
    private String phoneNumber;
    private String birth;
    private Role role;

    public Customer() {}
    public Customer(String nickname, String birth, String phoneNumber) {
        this.nickname = nickname;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
        this.role = Role.USER;
    }

    public Customer(String nickname, String birth, String phoneNumber, Role role) {
        this.nickname = nickname;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public String getBirth() {
        return birth;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void checkAdmin() throws Exception {
        if(!this.role.equals(Role.ADMIN)) {
            throw new Exception("고객의 권한이 없습니다.");
        }
    }
}
