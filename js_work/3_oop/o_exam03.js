/**
 * Prototype(프로토타입)
 * 
 */
const testObj = {};
console.log(testObj.__proto__);

function IdolModel(name, year) {
    this.name = name;
    this.year = year;
}

// console.log(IdolModel.prototype);
// console.dir(IdolModel.prototype, {
//     showHidden: true
// });
console.log(IdolModel.prototype.constructor === IdolModel);
console.log(IdolModel.prototype.constructor.prototype === IdolModel.prototype);

const wonyoung = new IdolModel('장원영', 2004);
console.log(wonyoung.__proto__);
console.log(wonyoung.__proto__ === IdolModel.prototype);

console.log(testObj.__proto__ === Object.prototype);
console.log(wonyoung.toString());
console.log(Object.prototype.toString());

console.log(IdolModel.__proto__ === Function.prototype);
console.log(Function.prototype.__proto__ === Object.prototype);
console.log(IdolModel.prototype.__proto__ === Object.prototype);

function IdolModel2(name, year) {
    this.name = name;
    this.year = year;

    this.sayHello = function () {
        return `${this.name}이(가) 인사합니다.`;
    }
}

const wonyoung2 = new IdolModel2('장원영', 2004);
const yujin2 = new IdolModel2('안유진', 2003);

console.log(wonyoung2.sayHello());
console.log(yujin2.sayHello());
console.log(wonyoung2.sayHello === yujin2.sayHello);
console.log(wonyoung2.hasOwnProperty('sayHello'));

function IdolModel3(name, year) {
    this.name = name;
    this.year = year;
}

IdolModel3.prototype.sayHello = function () {
    return `${this.name}이(가) 인사합니다.`;
}

const wonyoung3 = new IdolModel3('장원영', 2004);
const yujin3 = new IdolModel3('안유진', 2003);

console.log(wonyoung3.sayHello()); // 상위 프로토타입 체인에서 메서드를 찾아서 실행
console.log(yujin3.sayHello());

console.log(wonyoung3.sayHello === yujin3.sayHello);
console.log(wonyoung3.hasOwnProperty('sayHello'));

function Student(name, kor, eng, mat) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.mat = mat;
}

Student.prototype = {
    getTotal: function () {
        return this.kor + this.eng + this.mat;
    },
    getAverage: function () {
        return this.getTotal() / 3;
    },
    toString: function () {
        return `${this.name}\t${this.kor}\t${this.eng}\t${this.mat}\t${this.getTotal()}\t${this.getAverage()}`;
    }
}

let students = [];
students.push(new Student('홍길동', 100, 90, 80));
students.push(new Student('김길동', 90, 80, 70));

for (let i in students) {
    console.log(students[i].toString());
}
