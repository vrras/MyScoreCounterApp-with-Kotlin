package info.firastech.scorecounterapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    // deklarasi variabel
    var teamAName: String ? = null
    var teamBName: String ? = null

    var teamAScore: String ? = null
    var teamBScore: String ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // inisialisai
        teamAName = intent.getStringExtra("nameTeamA")
        teamBName = intent.getStringExtra("nameTeamB")
        teamAScore = intent.getStringExtra("scoreTeamA")
        teamBScore = intent.getStringExtra("scoreTeamB")

        // cari pemenang
        if (teamAScore?.toInt()!! > teamBScore?.toInt()!!){
            winner_team.text = teamAName
            team_a.text = "Team A : $teamAScore"
            team_b.text = "Team B : $teamBScore"
        } else if(teamAScore?.toInt()!! < teamBScore?.toInt()!!){
            winner_team.text = teamBName
            team_a.text = "Team A : $teamAScore"
            team_b.text = "Team B : $teamBScore"
        }else{
            winner_team.text = "DRAW"
            team_a.text = "Team A : $teamAScore"
            team_b.text = "Team B : $teamBScore"
        }
    }
}
