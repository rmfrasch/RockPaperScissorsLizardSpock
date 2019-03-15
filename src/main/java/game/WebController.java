package game;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class WebController {

	@GetMapping(name = "playagame")
	public String playGame(@RequestParam(name = "choice", required = false) String theChoice, Model model) {
		if(theChoice == null) {
			return "index";
		}
		String yourChoice = theChoice;
		String[] versus = {"rock", "paper", "scissors", "lizard", "spock"};
		
		int theOpp =(int) (Math.random()*4);
		String opponent = versus[theOpp];
		
		String theOutcome = "error";
		//You lose
		if(opponent.equals("rock") && (theChoice.equals("scissors") || theChoice.equals("lizard"))) {
			theOutcome = "lose";
		}else if(opponent.equals("scissors") && (theChoice.equals("paper") || theChoice.equals("lizard"))) {
			theOutcome = "lose";
		}else if(opponent.equals("paper") && (theChoice.equals("rock") || theChoice.equals("spock"))) {
			theOutcome = "lose";
		}else if(opponent.equals("lizard") && (theChoice.equals("paper") || theChoice.equals("spock"))) {
			theOutcome = "lose";
		}else if(opponent.equals("spock") && (theChoice.equals("scissors") || theChoice.equals("rock"))) {
			theOutcome = "lose";
		}
		//You win
		else if(opponent.equals("rock") && (theChoice.equals("spock") || theChoice.equals("paper"))) {
			theOutcome = "win";
		}else if(opponent.equals("scissors") && (theChoice.equals("rock") || theChoice.equals("spock"))) {
			theOutcome = "win";
		}else if(opponent.equals("paper") && (theChoice.equals("scissors") || theChoice.equals("lizard"))) {
			theOutcome = "win";
		}else if(opponent.equals("lizard") && (theChoice.equals("rock") || theChoice.equals("scissors"))) {
			theOutcome = "win";
		}else if(opponent.equals("spock") && (theChoice.equals("lizard") || theChoice.equals("paper"))) {
			theOutcome = "win";
		}
		//You tie
		else if(opponent.equals("rock") && theChoice.equals("rock")) {
			theOutcome = "tie";
		}else if(opponent.equals("paper") && theChoice.equals("paper")) {
			theOutcome = "tie";
		}else if(opponent.equals("scissors") && theChoice.equals("scissors")) {
			theOutcome = "tie";
		}else if(opponent.equals("lizard") && theChoice.equals("lizard")) {
			theOutcome = "tie";
		}else if(opponent.equals("spock") && theChoice.equals("spock")) {
			theOutcome = "tie";
		}

		model.addAttribute("outcome", theOutcome);
		model.addAttribute("opponent", opponent);
		model.addAttribute("youChose", yourChoice);
		return "results";
	}
}
