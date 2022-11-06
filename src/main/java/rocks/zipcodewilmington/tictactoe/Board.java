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

//        for(int i=0;i<3;i++){
//            int CountXRow=0;
//            int CountXCol=0;
//            for(int j=0;j<3;j++){
//                if(_matrix[i][j]=='X'){
//                    CountXRow++;
//                }
//                if(_matrix[j][i]=='X'){
//                    CountXCol++;
//                }
//                if(CountXRow ==3 || CountXCol==3){
//                    return true;
//                }
//            }
//        }
        String status=getWinner();
        if(status=="X")
            return  true;
        return false;
    }

    public Boolean isInFavorOfO() {
//        for(int i=0;i<3;i++){
//            int CountORow=0;
//            int CountOCol=0;
//            for(int j=0;j<3;j++){
//                if(_matrix[i][j]=='O'){
//                    CountORow++;
//                }
//                if(_matrix[j][i]=='O'){
//                    CountOCol++;
//                }
//                if(CountORow ==3 || CountOCol==3){
//                    return true;
//                }
//            }
//        }
//        return false;
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
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                sbRow.append(_matrix[i][j]);
                sbCol.append(_matrix[j][i]);
                if(i==j){
                    sbDiag1.append(_matrix[i][j]);
                }
            }
            al.add(sbRow.toString());
            al.add(sbCol.toString());
            sbRow.delete(0,sbRow.length());
            sbCol.delete(0,sbCol.length());
        }
        al.add(sbDiag1.toString());
        sbDiag2.append(_matrix[0][2]);
        sbDiag2.append(_matrix[1][1]);
        sbDiag2.append(_matrix[2][0]);
        al.add(sbDiag2.toString());
        for(String str:al)
            System.out.println(str);
        for(String str:al) {
            if (str.equals("XXX"))
                return "X";
            else if (str.equals("OOO"))
                return "O";
        }
            return "";
    }

}
