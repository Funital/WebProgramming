import './App.css'
import {useState, useEffect} from "react"

function App() {
  const [events, setEvents]=useState([])
  useEffect(()=>{
    fetch('/events')
        .then((response)=>{
            if(!response.ok){
              throw new Error("목록 조회 실패")
            }
            return response.json()
          })
        .then((data)=>{
          setEvents(data)
        })
        .catch((error)=>{
          console.error(error)
        })
  }, [])

  // ① GET 실습

  // ② POST 실습에서 입력창의 상태 추가


  // ③ DELETE 실습에서 이 위치에 deleteEvent(id)를 작성한다.


  // ④ PUT 실습에서 수정할 행사 ID 상태 추가


  return (
      <div className="app">
        <header className="app-header">
          <h1>행사 관리 시스템</h1>
          <p>React + Express REST API 실습</p>
          <div className="event-banner-placeholder">
            <img
                className="event-banner"
                src="/images/event-banner.jpg"
                alt="행사 안내 배너" />
          </div>
          {/*public 우클릭 → 새로 만들기(New) → 디렉터리(Directory) → images 입력->jpg*/}
        </header>

        <section className="panel">
          <div className="list-heading">
            <h2 className="panel-title">행사 목록</h2>
            <span className="count">총 {/*목록의 총 횟수*/}건</span>
          </div>

          <ul className="event-list">
            {events.map((event) => (
                <li key={event.id} className="event-item">
                  <div className="event-info">
                    <p className="event-title">{/*행사 주제*/}</p>
                    <span className="event-meta">
                  번호 {/*번호*/} · 정원 {/*정원*/}명
                </span>
                  </div>

                  <div className="event-actions">
                    {/* 수정 버튼의 onClick에 클릭 핸들러를 연결하세요.   버튼을 클릭하면 수정 시작 함수에 현재 행사(event)를 전달하세요. */}
                    <button type="button" className="btn btn-secondary btn-small">
                      수정
                    </button>

                    {/* 현재 행의 ID(event.id)가 수정 중인 행사 ID와 같을 때만 취소 버튼을 표시하세요.
                                    취소 버튼을 누르면 cancelEdit 함수가 실행되도록 onClick을 추가하세요. */}
                    <button type="button" className="btn btn-secondary btn-small">
                      취소
                    </button>

                    {/* 삭제 버튼에 onClick을 추가하세요.  클릭하면 삭제 함수에 현재 행사의 ID를 전달하세요.  */}
                    <button type="button" className="btn btn-danger btn-small">
                      삭제
                    </button>
                  </div>
                </li>
            ))}
          </ul>
        </section>



        <section className="panel">
          <h2 className="panel-title">행사 등록</h2>
          {/* POST 실습 : 폼을 제출하면 addEvent 함수가 실행되도록 아래 <form>의 onSubmit을 수정하세요.*/}
          {/* PUT 실습:  editingId 값에 따라 실행할 함수를 선택하도록 같은 onSubmit을 다시 수정하세요.
        editingId가 null이면 addEvent를 연결하세요. editingId에 행사 ID가 있으면 updateEvent를 연결하세요. */}
          <form className="event-form" onSubmit={(e) => e.preventDefault()}>
            <div className="field">
              <label htmlFor="event-title">행사 제목</label>

              {/* POST 실습 — 행사 제목 입력칸을 React 상태와 연결하세요.
                      1. value 속성을 추가해 eventTitle의 값을 입력칸에 표시하세요.
                      2. onChange 속성을 추가해 사용자가 입력할 때마다  새 입력값을 setEventTitle로 저장하세요.
                      힌트는 이벤트 객체의 target.value에서 새 입력값을 읽는 것입니다.*/}
              <input
                  id="event-title"
                  type="text"
                  placeholder="행사 제목 입력"

              />
            </div>

            <div className="field">
              <label htmlFor="event-capacity">정원</label>

              {/* ② POST 실습 — 정원 입력칸을 React 상태와 연결하세요.
                         1. value 속성을 추가해 capacity의 값을 입력칸에 표시하세요.
                         2. onChange 속성을 추가해 사용자가 입력할 때마다
                          새 입력값을 setCapacity로 저장하세요.   힌트는 이벤트 객체의 target.value에서 새 입력값을 읽는 것입니다.*/}
              <input
                  id="event-capacity"
                  type="number"
                  min="1"
                  placeholder="정원 입력"
              />
            </div>

            <button type="submit" className="btn btn-primary">
              {/* ④ PUT 실습 — 수정 상태에 따라 버튼에 표시할 글자를 바꾸세요.
                         1. editingId가 null이면 '등록'을 표시하세요.
                         2. editingId에 행사 ID가 있으면 '수정 완료'를 표시하세요.
                        힌트는 JSX의 중괄호 안에서 삼항 연산자(? :)를 사용하는 것입니다.
                        */}
              등록
            </button>
          </form>
        </section>


      </div>
  )

}

export default App