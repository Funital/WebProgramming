import './App.css'
import SongCard from './components/SongCard.jsx'
import {useState} from 'react'

function App(){
    const [songs, setSongs] = useState(
        [
            {id: 1, title: '밤하늘', artist: 'aaa', genre: '발라드', liked: false},
            {id: 2, title: '밤바다', artist: 'bbb', genre: '댄스', liked: false},
            {id: 3, title: '노을', artist: 'ccc', genre: '인디',  liked: false}
        ]
    )

    const [selectedGenre, setSelectedGenre]=useState('전체')
    const filterSongs=songs.filter(song=>selectedGenre==='전체' || selectedGenre===song.genre)

    function toggleLike(id){
        setSongs(preSongs => (
            preSongs.map(
                song => song.id===id?{...song, liked: !song.liked}:song
            )
        ))
    }

    return (
        <div className="app">
            <h1>MY PLAYLIST</h1>
            <div className="genre-filter">
                {
                    ['전체','발라드','댄스','인디'].map((genre)=>(
                        <button key={genre} type="button" onClick={()=>setSelectedGenre(genre)}>
                            {genre}
                        </button>
                    ))
                }
            </div>
            <div className="song-list">
                {
                    filterSongs.map((song) => (
                        <SongCard key={song.id} song={song} onToggleLike={toggleLike}></SongCard>
                    ))
                }
            </div>
        </div>
    )
}

export default App