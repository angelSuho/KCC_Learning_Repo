/**
 * 자바 스크립트 객체
 * 1. 사용자 정의 객체
 *   1. Object
 *   2. 객체 리터럴
 *   3. 생성자 함수(프로토타입)
 * 2. 내장 객체(built-in, native) - Array, Date, Math, RegExp ...
 *   1. core objects: String, Number, Boolean, Object, Function, Array, ...
 *   2. 브라우저 객체 모델(BOM): window, screen, location, history, navigator, ...
 *   3. 문서 객체 모델(DOM): document, element, attribute, text, ...
 */
// 1) 사용자 정의 객체
// 1. Object
// -> 자바스크립트 객체는 동적으로 프로퍼티를 추가/삭제할 수 있다.

let obj = new Object();
console.log(obj);

obj.name = '홍길동';
obj.age = 20;

console.log(obj);
console.log(`이름: ${obj.name}, 나이: ${obj.age}`);

// 함수는 1급 객체이다.
function add(a, b) {
    return a + b;
}

console.log(typeof add);
console.log(add instanceof Object);
add.qwe = 10;

console.log(add.qwe);
console.log(add(10, 20));

// 2. 리터럴 형식으로 객체 사용 -> 1개의 객체만 생성해서 사용하는 경우
let obj2 = {
    name: '김길동',
    age: 30,
    print: function () {
        console.log(`${this.name}님은 ${this.age}세 입니다.`);
    }
};

obj2.print();
console.log(`나이: ${obj2['age']}`);
console.log(`나이: ${obj2.age}`);

// 퀴즈> 리터럴 형식으로 빈객체를 생성 후
// 동적 프로퍼티와 함수를 추가 후 호출하는 예제를 구현하시오.
let coin = {}

coin.name = '비트코인';
coin.price = 100_000_000;
coin.print = function () {
    console.log(`${this.name} ${this.price}간다`);
}

coin.print();

// 객체 디스트럭처링: 객체의 프로퍼티를 분해해서 변수에 할당하는 것
let person = {
    name: '홍길동',
    age: 20,
    address: '서울'
};

let {name, age, address} = person;
console.log(name, age, address);

// const 객체 생성
// 1) const로 선언할 경우, 객체 자체를 변경할 수는 없다.
// 2) 객체의 프로퍼티는 변경할 수 있다.
const obj3 = {
    name: '홍길동',
    age: 20
};

// obj3 = {}; // Error
obj3.age = 30;
console.log(obj3);

let obj4 = {};
obj4.a = 10;
obj4.b = 20;
obj4.plus = function () {
    return this.a + this.b;
}
// obj4.plus = () => {
//     return this.a + this.b;
// }

console.log(obj4.plus());

// 퀴즈> Rectangle 생성자 함수를 만들고 사각형 넓이를 구하여 보자
// (width, height, getArea())
function Rectangle(width, height) {
    this.width = width;
    this.height = height;
    this.getArea = function () {
        return this.width * this.height;
    }
}

let rect = new Rectangle(10, 20);
console.log(`사각형 넓이: ${rect.getArea()}`);