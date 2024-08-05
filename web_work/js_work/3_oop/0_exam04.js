/**
 * class 기반의 객체지향 프로그래밍
 */
class IdolModel {
    name;
    year;

    constructor(name, year) {
        this.name = name;
        this.year = year;
    }

    sayHello() {
        return `${this.name}이(가) 인사합니다`;
    }
}

console.log(new IdolModel('장원영', 2004));

class IdolModel2 {
    #name;
    #year; // private field: #

    constructor(name, year) {
        this.#name = name;
        this.#year = year;
    }

    set name(name) {
        this.#name = name;
    }

    get name() {
        return this.#name;
    }

    static returnGroupName() {
        return '아이브';
    }
}

let wonYoung = new IdolModel2('장원영', 2004);
console.log(wonYoung.name);
wonYoung.name = '장원영2';
console.log(wonYoung.name);
console.log(IdolModel2.returnGroupName());

class IdolModel3 {
    name;
    year;

    constructor(name, year) {
        this.name = name;
        this.year = year;
    }

    static fromObject(obj) {
        return new IdolModel3(
            obj.name,
            obj.year
        );
    }

    static fromList(list) {
        return new IdolModel3(list[0], list[1]);
    }
}

const yujin = IdolModel3.fromObject({
    name: '안유진',
    year: 2003
});
console.log(yujin);
const wonYoung2 = IdolModel3.fromList(['장원영', 2004]);
console.log(wonYoung2);