/**
 * 상속
 */
class IdolModel {
    name;
    year;

    constructor(name, year) {
        this.name = name;
        this.year = year;
    }

    sayHello() {
        return `안녕하세요 ${this.name} 입니다.`;
    }
}

class FemaleIdolModel extends IdolModel {
    part;

    constructor(name, year, part) {
        super(name, year);
        this.part = part;
    }

    dance() {
        return `여자 아이돌이 춤을 춥니다.`;
    }

    sayHello() {
        return super.sayHello() + `아이브에서 ${this.part} 파트를 맡고 있습니다.`;
    }
}

const wonYoung = new FemaleIdolModel('장원영', 2004, '보컬');
console.log(wonYoung);
console.log(wonYoung.dance());

console.log(wonYoung instanceof FemaleIdolModel);
console.log(wonYoung instanceof IdolModel);
console.log(wonYoung.sayHello());

const iveMembers = [
    "안유진", "가을", "레이", "장원영", "리즈", "이서" ];
console.log(iveMembers.map(member => member));
console.log(iveMembers.map((member) => `아이브: ${member}`));
