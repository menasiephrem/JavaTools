

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Menasi
 */
public class DataBaseGenerator {
    static String inti ="INSERT INTO `lyric` (`_id`, `lyric_title`, `lyric_album_id`, "
            + "`lyric_actual_lyric`, `lyric_is_fav`)"
            + " VALUES  ";
   
    
    public static void main(String[] args) {
        WriteOnFIle(inti);
        
    }


private static void WriteOnFIle(String code) {
   Path path;
 
       path= Paths.get("songlyricSong3.sql");
        Charset caset = Charset.forName("UTF-8");
       
        try(BufferedWriter writer = Files.newBufferedWriter(path, caset)) {
            
           
          
             String id ;
                String title  ;
                String lyric ;
         
                int _fav ;
                System.out.println(""+Song.InsertQuery.length);
            for (int i = 750; i <Song.InsertQuery.length ; i++) {
                 id = Song.InsertQuery[i].get_albumId();
                 title =Song.InsertQuery[i].get_title();
                 lyric = Song.InsertQuery[i].get_actualLyric();
                 _fav = Song.InsertQuery[i].get_isFav();
          
              inti = inti + "(NULL,"+"'"+title+"',"+"'"+id+"',"+
                      "'"+lyric+"',"+_fav+"),";
            }
            
            writer.append(inti, 0, inti.length());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    
}


