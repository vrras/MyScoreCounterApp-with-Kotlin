package info.firastech.scorecounterapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Event click score A
        btn_add_score_a.onClick {
            // increment
            // TODO 1 : Ambil score terakhir dari text view
            val curScoreA: Int = score_a.text.toString()?.toInt()
            // TODO 2 : incrementing
            val newScore: Int = curScoreA + 1
            // TODO 3 : set lagi value ke widget text view
            score_a.text = newScore.toString()
        }
        // Event click score B
        btn_add_score_b.onClick {
            // increment
            val curScoreB: Int = score_b.text.toString()?.toInt()
            val newScore: Int = curScoreB + 1
            score_b.text = newScore.toString()
        }

        // Event Click Team A
        team_a.onClick {
            var currTeamName = team_a.text.toString()
            var newTeamName: EditText ? = null
            // tampilkan alert dialog
            alert {
                title = "Edit Team Name"
//                customView = layoutInflater.inflate(R.layout.item_team, null)
                customView {
                    // buat edit text
                    newTeamName = editText(currTeamName) {
                        hint = "Enter you team name"
                    }
                }
                // positive button
                yesButton {
                    // ambil nama baru edit text
//                    var newName: String = etTeamName.text.toString()
                    // pastikan new namenya tidak kosong
//                    if(newName.isNotEmpty()){
                        // set name baru ke text view
//                        team_a.text = newName
//                    }else{
//                        team_a.error = "Nama team tidak boleh kosong"
//                    }
                    // set nilai ke widget text view
                    team_a.text = newTeamName?.text.toString()
                }
            }.show()
        }

        team_b.onClick {
            var currTeamName = team_b.text.toString()
            var newTeamName: EditText ? = null
            // tampilkan alert dialog
            alert {
                title = "Edit Team Name"
//                customView = layoutInflater.inflate(R.layout.item_team, null)
                customView {
                    // buat edit text
                    newTeamName = editText(currTeamName) {
                        hint = "Enter you team name"
                    }
                }
                // positive button
                yesButton {
                    // ambil nama baru edit text
//                    var newName: String = etTeamName.text.toString()
                    // pastikan new namenya tidak kosong
//                    if(newName.isNotEmpty()){
                    // set name baru ke text view
//                        team_a.text = newName
//                    }else{
//                        team_a.error = "Nama team tidak boleh kosong"
//                    }
                    // set nilai ke widget text view
                    team_b.text = newTeamName?.text.toString()
                }
            }.show()
        }

        btn_finish.onClick {
            val teamAName = team_a.text.toString()
            val teamBName = team_b.text.toString()

            val teamAScore = score_a.text.toString()
            val teamBScore = score_b.text.toString()

            // start new activity with data
            startActivity(intentFor<ResultActivity>("nameTeamA" to teamAName,
                                                    "nameTeamB" to teamBName,
                                                    "scoreTeamA" to teamAScore,
                                                    "scoreTeamB" to teamBScore))
        }
    }
}
