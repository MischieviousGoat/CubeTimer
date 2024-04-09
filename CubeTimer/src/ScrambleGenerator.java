import java.util.*;
import java.awt.*;
import javax.swing.*;

public class ScrambleGenerator extends JLabel {
    String[] moves = {"R", "U", "F", "L", "B", "D"};
    String[] directions = {"", "'", "2"};
    public String scramble = "";
    String prevMove;
    String prev2Move;

    public ScrambleGenerator() {
        generateScramble();
        setText(scramble);
        // setBounds(0, 1080 / 3 - 250, 1920, 300);
        setBounds(0, -100, 1920, 300);
        setFont(new Font("Verdana", Font.PLAIN, 25));
        setForeground(Color.WHITE);
        setHorizontalAlignment(JTextField.CENTER);
        scramble = "";
    }

    public void generateScramble() {
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            int randMove = rand.nextInt(moves.length);
            int randDir = rand.nextInt(directions.length);
            if (prevMove != moves[randMove] && prev2Move != moves[randMove]) {
                scramble += moves[randMove] + directions[randDir] + " ";
            }
            System.out.print(prevMove);
            prev2Move = prevMove;
            System.out.print(prev2Move);
            prevMove = moves[randMove];
            System.out.print(prevMove);
            System.out.print(moves[randMove]);
            System.out.println(scramble);
        }
        if (scramble.length() < 50) {
            generateScramble();
        }
    }
}

/*
 * nullnullLLL' 
LLLLL'
LLRRL' R
RRFFL' R F
FFUUL' R F U
UUUUL' R F U
UULLL' R F U L2
LLLLL' R F U L2
LLDDL' R F U L2 D
DDLLL' R F U L2 D
LLUUL' R F U L2 D U
UUUUL' R F U L2 D U
UULLL' R F U L2 D U L'
LLUUL' R F U L2 D U L'
UUFFL' R F U L2 D U L' F2
FFDDL' R F U L2 D U L' F2 D
DDLLL' R F U L2 D U L' F2 D L
LLUUL' R F U L2 D U L' F2 D L U'
UUFFL' R F U L2 D U L' F2 D L U' F2
FFFFL' R F U L2 D U L' F2 D L U' F2
FFDDL' R F U L2 D U L' F2 D L U' F2 D
DDUUL' R F U L2 D U L' F2 D L U' F2 D U'
UUFFL' R F U L2 D U L' F2 D L U' F2 D U' F
FFRRL' R F U L2 D U L' F2 D L U' F2 D U' F R'
RRFFL' R F U L2 D U L' F2 D L U' F2 D U' F R'
FFFFL' R F U L2 D U L' F2 D L U' F2 D U' F R'
FFRRL' R F U L2 D U L' F2 D L U' F2 D U' F R' R'
RRDDL' R F U L2 D U L' F2 D L U' F2 D U' F R' R' D2
DDRRL' R F U L2 D U L' F2 D L U' F2 D U' F R' R' D2
RRFFL' R F U L2 D U L' F2 D L U' F2 D U' F R' R' D2 F2
FFDDL' R F U L2 D U L' F2 D L U' F2 D U' F R' R' D2 F2 D'
DDLLL' R F U L2 D U L' F2 D L U' F2 D U' F R' R' D2 F2 D' L'
LLLLL' R F U L2 D U L' F2 D L U' F2 D U' F R' R' D2 F2 D' L'
LLLLL' R F U L2 D U L' F2 D L U' F2 D U' F R' R' D2 F2 D' L'
LLUUL' R F U L2 D U L' F2 D L U' F2 D U' F R' R' D2 F2 D' L' U'
UUDDL' R F U L2 D U L' F2 D L U' F2 D U' F R' R' D2 F2 D' L' U' D
DDDDL' R F U L2 D U L' F2 D L U' F2 D U' F R' R' D2 F2 D' L' U' D
DDRRL' R F U L2 D U L' F2 D L U' F2 D U' F R' R' D2 F2 D' L' U' D R2
RRDDL' R F U L2 D U L' F2 D L U' F2 D U' F R' R' D2 F2 D' L' U' D R2
DDRRL' R F U L2 D U L' F2 D L U' F2 D U' F R' R' D2 F2 D' L' U' D R2
 */
