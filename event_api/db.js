const {DatabaseSync} = require("node:sqlite"); // sqlite 불러오겠다.
const db = new DatabaseSync("events.db");
console.log("db 성공");

db.exec(
    `
    CREATE TABLE IF NOT EXISTS events(
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        title TEXT NOT NULL,
        capacity INTEGER NOT NULL
    )
    `
);

console.log("테이블 생성 완료")

// 다른 js 파일에서 현재의 db 객체를 사용할 수 있도록 내보내는 역할
module.exports=db;
