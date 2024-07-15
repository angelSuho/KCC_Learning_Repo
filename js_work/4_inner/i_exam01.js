/**
 * Array (배열)
 */
let kccMembers = [
    '진아',
    '수호',
    '한희',
    '채원',
    '주언',
    '연호'
];

console.log(kccMembers);

// push(): 배열의 끝에 요소 추가
console.log('push() 메소드');
console.log(kccMembers.push('승언'));
console.log(kccMembers);
console.log("-------------------");

// pop(): 배열의 끝 요소 제거
console.log('pop() 메소드');
console.log(kccMembers.pop());
console.log(kccMembers);
console.log("-------------------");

// shift(): 배열의 첫 요소 제거
console.log('shift() 메소드');
console.log(kccMembers.shift());
console.log(kccMembers);
console.log("-------------------");

// unshift(): 배열의 첫 요소 추가
console.log('unshift() 메소드');
console.log(kccMembers.unshift("현민"));
console.log(kccMembers);
console.log("-------------------");

// splice(): 배열의 특정 요소 제거
console.log('splice() 메소드');
console.log(kccMembers.splice(0, 3));
console.log(kccMembers);
console.log("-------------------");

// 불변성 함수
kccMembers = [
    '진아',
    '수호',
    '한희',
    '채원',
    '주언',
    '연호'
];

console.log("-------------------");
console.log(kccMembers);
console.log("-------------------");

// concat(): 배열의 요소를 합쳐서 새 배열 생성
console.log('concat() 메소드');
console.log(kccMembers.concat('승우'));
console.log(kccMembers); // 원본 배열은 변하지 않음. 불변
console.log("-------------------");

// slice(): 배열의 일부분을 새 배열로 반환
console.log('slice() 메소드');
console.log(kccMembers.slice(0, 4));
console.log(kccMembers); // 원본 배열은 변하지 않음. 불변
console.log("-------------------");

// spread 연산자: 배열의 요소를 개별 요소로 분리
console.log('spread 연산자');
let kccMembers2 = [...kccMembers];
console.log(kccMembers2);
console.log("-------------------");
let kccMembers3 = kccMembers;
console.log(kccMembers3);
console.log(kccMembers === kccMembers3); // true
console.log(kccMembers === kccMembers2); // false

let kccMembers4 = ['홍길동', '박길동' ,...kccMembers, '조길동', '한길동'];
console.log(kccMembers4);

let arr1 = [100, 200, 300];
function sum(a, b, c) {
    return a + b + c;
}
console.log(sum(...arr1)); // 파라미터 별로 전달하지 않아도, 배열의 요소가 개별 파라미터로 전달됨
// 이런게 가능하다니... 신기하다.
console.log("-------------------");

// join(): 배열의 요소를 연결한 문자열 반환
console.log('join() 메소드');
console.log(kccMembers.join('/'));
console.log(kccMembers.join(', '));
console.log("-------------------");

// sort(): 배열의 요소를 정렬
console.log('sort() 메소드');
console.log(kccMembers.sort()); // 오름차순 정렬
console.log(kccMembers); 
console.log(kccMembers.reverse()); // 내림차순 정렬
console.log(kccMembers); 

let numbers = [1, 8, 3, 2, 6];
console.log(numbers);
console.log(numbers.sort());
console.log(`오름차순 정렬`);
console.log(numbers.sort((a, b) => a - b)); // 오름차순 정렬
console.log(`내림차순 정렬`);
console.log(numbers.sort((a, b) => b - a)); // 내림차순 정렬

const books = [
    {
        name: '이것이 자바다.',
        price: 30000,
        publisher: '한빛미디어'
    },
    {
        name: '스프링 정석',
        price: 35000,
        publisher: '길벗'
    },
    {
        name: '도커의 완성',
        price: 20000,
        publisher: '이지스퍼블릭'
    }
];

/**
 * 과제 1>
 * 이름을 기준으로 오름차순하고 전체 출력하세요. (for ~ in, for ~ of)
 */
// localeCompare: 문자열과 문자열을 비교하고, 정렬순서에 따른 비교를 할 수 있다.
books.sort((a, b) => a.name.localeCompare(b.name)); 
for (let idx of books) {
    console.log(idx);
}
console.log("-------------------");

// forEach: 배열의 요소를 순회하면서 콜백함수를 실행
console.log('forEach() 메소드');
books.forEach((book) => {
    console.log(book);
});

// for ~ in
console.log('for ~ in');
for (let idx in books) {
    console.log(books[idx]);
}
console.log("-------------------");

// for ~ of
console.log('for ~ of');
for (let idx of books) {
    console.log(idx);
}
console.log("-------------------");

// map(): 배열의 요소를 순회하면서 콜백함수를 실행하고, 새로운 배열을 반환
console.log('map() 메소드');
let iveMembers = ['유진', '가을', '레이', '원영', '리즈', '이서'];
let newMembers = iveMembers.map((member) => {
    return member + '님';
});
console.log(newMembers);
console.log('-------------------');

// filter: 배열의 요소를 순회하면서 콜백함수를 실행하고, 조건에 맞는 요소만 반환 (다수의 요소 반환)
console.log('filter() 메소드');
let numbers2 = [1, 2, 3, 4, 5, 6, 7, 8, 9];
let evenNumbers = numbers2.filter((number) => {
    return number % 2 === 0;
});
console.log(evenNumbers);
console.log("-------------------");

// find(): 배열의 요소를 순회하면서 콜백함수를 실행하고, 조건에 맞는 요소를 반환 (단일 요소 반환)
console.log('find() 메소드');
let numbers3 = [10, 20, 30, 40, 50];
let result = numbers3.find((number) => {
    return number > 30;
});
console.log(result);
console.log("-------------------");

// findIndex(): 배열의 요소를 순회하면서 콜백함수를 실행하고, 조건에 맞는 요소의 인덱스를 반환
console.log('findIndex() 메소드');
let numbers4 = [10, 20, 30, 40, 50];
let result2 = numbers4.findIndex((number) => {
    return number > 30;
});
console.log(result2);
console.log("-------------------");

// reduce(): 배열의 요소를 순회하면서 콜백함수를 실행하고, 하나의 결과값을 반환
console.log('reduce() 메소드');
let numbers5 = [1, 2, 3, 4, 5];
let sum2 = numbers5.reduce((acc, cur) => {
    return acc + cur;
}, 0); // acc 초기값 0, acc: 누적값, cur: 현재값
console.log(sum2);
console.log("-------------------"); 

// 퀴즈> iveMembers 변수에 있는 모든 string값들을 더해 보자.
const rlt = iveMembers.reduceRight((acc, cur) => {
    return acc + cur.length
}, 0);
console.log(rlt);

