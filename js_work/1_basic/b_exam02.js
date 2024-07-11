// 변수 선언, 사용
var num = 100;
num = '안녕';
console.log(num);

// 컴파일 언어: 데이터형, 문법 -> 엄격히 요구
// 인터프리터 언어: 문법적으로 느슨한 것을 요구

// var: 여러 큰 스코프에서 공유하기 위한 최상위 변수 사용
// let: 작은 스코프에서 로컬 변수 사용
// const: 상수값으로 사용

let a = 10;
a = '안녕';
console.log(a);

// 데이터 타입 (자료형)
// 숫자형(number)
let intNum = 10;
let floatNum = 3.14;
console.log(typeof intNum);
console.log(typeof floatNum);

// 문자형(string)
let sinS = 'single';
let doubleS = "double";

console.log(typeof sinS);
console.log(typeof doubleS);

/* 
* Template Literal
  1. newline -> \n
  2. tab -> \t
  3. \(백슬러시) 문자열 안에 표현 -> \\
*/

const kcc = "김진아\n이수호";
console.log(kcc);

const kccT = "김진아\t이수호";
console.log(kccT);

const kccB = "김진아\\이수호";
console.log(kccB);

const kccBT = `김지안 \ 
               ^^V "a"`;
console.log(kccBT);

const groupName = 'kcc';
console.log(groupName + ' 이수호');
console.log(`${groupName} 이한희`);

// 논리형 (boolean)
let bootVar = true;
console.log(typeof boolVar);
console.log(!false); // true
console.log(!!false); // false
console.log(!!''); // false
console.log(!!0); // false
console.log(!!undefined); // false
console.log(!!null); // false
console.log(!!'0'); // true
console.log(!!{}); // true
console.log(!![]); // true

// undefined
let emptyVar;
console.log(typeof emptyVar);

// null
let nullVar = null;
console.log(typeof nullVar);

// 함수 (function)
let fun = function() {};
console.log(typeof fun);

// 객체 (object)
let person = {
  name: `홍길동`,
  age: 20
}

console.log(typeof person);
console.log(person.name);
console.log(person['age']);

// 배열 (Array)
const kccMember = [
  "김현민",
  "윤채원",
  "김연호",
  "원승언"
];

console.log(typeof kccMember);
console.log(kccMember)

/*
  Symbol 타입
  - 유일무이한 값을 생성할 때 사용
*/

const test1 = '1';
const test2 = '1';

console.log(test1 === test2);
const symbol1 = Symbol('1');

const symbol2 = Symbol('1');
console.log(symbol1 === symbol2);

/**
 * 타입변환(형변환)
 * 1) 명시적
 * 2) 암묵적
 */

// 명시적
let age = 20;
let stringAge = age.toString();
console.log(typeof stringAge);

// 암묵적
let test = age + '';
console.log(typeof test);

console.log('100' + '2');
console.log('100' * '2');
console.log('100' - '2');

// 문자열 -> number형: eval(), Number(), parseInt(), parseFloat()
// 웬만하면 parseInt, parseFloat를 사용하는 것이 좋음
let strTonum = '100';
strTonum = eval(strTonum);
let result = strTonum + 100;
console.log(result);

/**
 * Hoisting(호이스팅)
 * - 모든 변수 선언문이 코드 최상단으로 이동되는 것처럼 느껴지는 현상
 *   - 스크립트 내 변수와 함수의 선언 순서에 상관 없이 순서가 '끌어올려~~'진 듯한 현상
 *   - 포인트는 물리적으로 '끌어올려'지는 것이 아니라 
 *     자바스크립트 엔진이 먼저 전체 코드를 한 번 스캔하고 실행컨텍스트에 미리 기록해 놓기 때문에 이런 현상이 발생하는 것
 */
// var name;
// console.log(name); // undefined
// name = '홍길동';
// console.log(name);

// console.log(kim);
// var kim = '김씨';

console.log(kim);
const kim = '김씨';