package rocks.zipcodewilmington.tictactoe;

import java.util.ArrayList;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    private Character[][] _matrix;
    public Board(Character[][] matrix) {
        this._matrix=matrix;
    }

    public Boolean isInFavorOfX() {
        String status=getWinner();
        if(status=="X")
            return  true;
        return false;
    }

    public Boolean isInFavorOfO() {
        String status=getWinner();
        if(status=="O")
            return  true;
        return false;
    }

    public Boolean isTie() {
        String status=getWinner();
        if(status=="")
            return  true;
        return false;
    }

    public String getWinner() {
        StringBuilder sbRow=new StringBuilder() ;
        StringBuilder sbCol=new StringBuilder() ;
        StringBuilder sbDiag1=new StringBuilder() ;
        StringBuilder sbDiag2=new StringBuilder() ;
        ArrayList<String> al=new ArrayList<String>();
        int matLength=2;
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                sbRow.append(_matrix[i][j]);
                sbCol.append(_matrix[j][i]);
                if(i==j){
                    sbDiag1.append(_matrix[i][j]);
                }
                if(i+j==matLength){
                    sbDiag2.append(_matrix[matLength-j][j]);
                }
            }
            al.add(sbRow.toString());
            al.add(sbCol.toString());
            sbRow.delete(0,sbRow.length());
            sbCol.delete(0,sbCol.length());
        }
        al.add(sbDiag1.toString());
        al.add(sbDiag2.toString());

        for(String str:al) {
            if (str.equals("XXX"))
                return "X";
            else if (str.equals("OOO"))
                return "O";
        }
            return "";
    }

}
