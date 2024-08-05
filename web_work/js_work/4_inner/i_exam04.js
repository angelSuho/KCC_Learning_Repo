/**
 * 정규 표현식(Regular Expression)
 */
// 1. 문자열.match(정규표현식) -> 매칭된 결과(문자열) return
let result = 'sports'.match(/sp/);
console.log(result); // [ 'sp', index: 0, input: 'sports', groups: undefined ]

// 2. RegExp.exec('문자열') -> 매칭된 결과(문자열) return
const str = 'qwewqdsadgrfvfdnyjnygb fdg erg wdsf wsd qweqse';
const re = /fS/ig; // i: 대소문자 구분없이, g: 전역 검색
result = re.exec(str);

while (result) {
    console.log(result);
    result = re.exec(str);
}

// 퀴즈 1> July 16 2024 문자열을 정규표현식으로 검색
const answer1 = 'This is a data: July 16 2024';
const req = /^[\D]+\s\d{2}\s\d{4}$/ig;
result = req.exec(answer1);
console.log(result);

// 퀴즈 2> 문자열을 replace()를 사용하여 SW -> 소프트웨어로 변경
const answer2 = '오늘 우리는 SW 세상에서 살고 있다. SW가 매우 중요한 시기이다. 그래서 SW를 열심히 공부하자.';
const re2 = /SW/ig;
result = answer2.replaceAll(re2, '소프트웨어');
console.log(result);

const answer3 = 'Java--JavaScript';
const re3 = /(\w+)-{2}(\w+)/;
result = answer3.replace(re3, "$2--$1");
console.log(result); // JavaScript--Java

// 이메일 체크
// 정규표현식.test(문자열) -> 해당 문자열이 정규표현식에 매칭 되는지 유무(true/false) return
// 정상: suho@example.com
// 비정상: suho@.comasdasd, suho@com
const emailReq = /^[a-zA-Z][\w]+@{1}[a-z]+\.{1}.(com|net)$/;
const input = 'suho@nav.com';
if (emailReq.test(input)) {
    console.log('정상');
    console.log(input);
} else {
    console.log('비정상');
    console.log(input);
}