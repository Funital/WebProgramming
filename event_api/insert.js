const db = require("./db");
const insert = db.prepare("INSERT INTO events(title, capacity) VALUES (?,?)");
insert.run("웹프로그래밍특강", 89);
insert.run("AI 특강", 30)

console.log("insert 정상 실행")