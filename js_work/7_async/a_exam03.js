/**
 * Async / Await
 * Async: 비동기식 프로그램을 동기식 프로그램처럼 작성할 수 있게 해주는 키워드
 * Await: Promise 객체를 반환하는 함수의 실행을 기다려주는 키워드
 */

const getPromise = (seconds) => 
    new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve('완료');
        }, seconds * 1000);
});

// refactor
async function runner() {
    const result = await getPromise(3);
    console.log(result);
    const result2 = await getPromise(2);
    console.log(result2);
}
// await로 함수가 끝날때까지 기다린다. 
// async로 진행되더라도, await가 있으면 기다린다.
// await는 함수 앞에서만 사용할 수 있다.
// await는 async 함수 안에서만 사용할 수 있다.
// runner();

async function runner2() {
    const result = await getPromise(1);
    console.log(result);
    const result2 = await getPromise(2);
    console.log(result2);
    const result3 = await getPromise(1);
    console.log(result3);
}

// runner2();

function moneyLend(borrow) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            if (Math.random() < 0.1) {
                reject('채무자 파산');
            }

            resolve(borrow * 1.1);
        }, 1000);
    });
}

async function lend() {
    try {
        const lend1 = await moneyLend(10);
        const lend2 = await moneyLend(lend1);
        const lend3 = await moneyLend(lend2);
        const lend4 = await moneyLend(lend3);
        const lend5 = await moneyLend(lend4);

        console.log(`대출금액: ${lend5}만원`);
    } catch (e) {
        console.log(e);
    } finally {
        console.log('완료');
    }
}

lend();