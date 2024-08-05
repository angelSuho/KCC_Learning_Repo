/**
 * 비동기식 (Async)
 */

function longWork() {
    const now = new Date();
    const milliseconds = now.getTime();
    const afterTwoSeconds = milliseconds + 2 * 1000;

    while(new Date().getTime() < afterTwoSeconds) {};
    console.log('완료')
}

// 동기식 프로그램
// 동기식 프로그램은 순차적으로 실행되는 것이다.
// console.log('Hello');
// longWork();
// console.log('World');

// 비동기식 프로그램은 특정 이벤트가 발생했을 때 실행되는 것이다.
// 비동기식 프로그램은 동기식 프로그램과 다르게 실행되는 순서가 다를 수 있다.
// ajax, setTimeout, setInterval, 이벤트 핸들러 등 비동기식 프로그램은 동기식 프로그램과 다르게 실행되는 순서가 다를 수 있다.
function longWorkAsync() {
    setTimeout(() => {
        console.log('완료');
    }, 2000);
}

// console.log('Hello');
// longWorkAsync();
// console.log('World');

function waitAndRun() {
    setTimeout(() => {
        console.log("1");
        setTimeout(() => {
            console.log("2");
            setTimeout(() => {
                console.log("3");
            }, 2000);
        }, 2000);
    }, 2000);
}

waitAndRun();
