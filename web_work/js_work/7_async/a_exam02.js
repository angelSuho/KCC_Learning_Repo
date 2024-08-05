/**
 * Promise
 */
const timeoutPromise = new Promise((resolve, reject) => {
    setTimeout(() => {
     resolve('완료');   
    }, 2000)    
});

// timeoutPromise.then((res) => {
//     console.log("-----then-----");
//     console.log(res);
// });

const getPromise = (seconds) => 
    new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve('완료');
        }, seconds * 1000);
});

// getPromise(3).then((res) => {
//     console.log('-----then-----');
//     console.log(res);
//     return getPromise(3);
// }).then((res) => {
//     console.log('-----then-----');
//     console.log(res);
// });

// ------ reject ------
const rejectPromise = (secconds) => new Promise((resolve, reject) => {
    setTimeout(() => {
        reject('에러 발생');
    }, secconds * 1000);
});

// rejectPromise(3).then((res) => {
//     console.log(res);
// }).catch((res) => {
//     console.log('-----catch-----');
//     console.log(res);
// }).finally(() => {
//     console.log('-----finally-----');
// });

// 과제 1> 빌린돈에 대해 원금 + 이자(10%) 에 대한 상환금액을 비동기식으로 구현하시오
const borrow = 20;
const borrowPromise = new Promise((resolve, reject) => {
    setTimeout(() => {
        resolve(borrow * 1.1);
    }, 2000);
});

// borrowPromise.then((res) => {
//     console.log(`${res}만원`);
// }).catch((res) => {
//     console.log('-----catch-----');
//     console.log(res);
// }).finally(() => {
//     console.log('-----finally-----');
// })
// console.log('-----Promise-----');

Promise.all([getPromise(1), getPromise(4), getPromise(1)])
.then((res) => {
    console.log('-----Promise.all-----');
    console.log(res);
});