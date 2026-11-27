function SongCard({song, onToggleLike}){
    return(
        <div className="song-card">
            <div className="song-info">
                <h1>{song.title}</h1>
                <p>{song.artist}</p>
                <span>{song.genre}</span>
            </div>
            <button type="button" className="like-button" onClick={()=>onToggleLike(song.id)}>
                {
                    song.liked?'👍':'👎'
                }
            </button>
        </div>
    )
}

export default SongCard