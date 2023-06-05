package com.example.qwirkle;

import static com.example.qwirkle.EnterDetails.client;
import static com.example.qwirkle.EnterDetails.player;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class GameModel extends MainActivity {
    List<Tile> tiles;
    Tile currentTile;
    ConcurrentHashMap<Integer,Block> blocks;
    String[][] ids;
    Random r;
    List<Tile> allTiles;
    public GameModel() throws InterruptedException {

            tiles=Collections.synchronizedList(new ArrayList<>());
            currentTile=null;
            blocks= new ConcurrentHashMap<>();
            r=new Random();


            ImageView one=mainActivity.findViewById(R.id.imageView1);
            ImageView two=mainActivity.findViewById(R.id.imageView2);
            ImageView three=mainActivity.findViewById(R.id.imageView6);
            ImageView four=mainActivity.findViewById(R.id.imageView5);
            ImageView five=mainActivity.findViewById(R.id.imageView4);
            ImageView six=mainActivity.findViewById(R.id.imageView3);

            //flower
            ImageView imageView=new ImageView(context);
            imageView.setImageResource(R.drawable.g2);
            tiles.add(new Tile(imageView,"green","flower"));
            ImageView imageView1=new ImageView(context);
            imageView1.setImageResource(R.drawable.b2);
            tiles.add(new Tile(imageView1,"blue","flower"));
            ImageView imageView2=new ImageView(context);
            imageView2.setImageResource(R.drawable.o2);
            tiles.add(new Tile(imageView2,"orange","flower"));
            ImageView imageView3=new ImageView(context);
            imageView3.setImageResource(R.drawable.p2);
            tiles.add(new Tile(imageView3,"purple","flower"));
            ImageView imageView4=new ImageView(context);
            imageView4.setImageResource(R.drawable.y2);
            tiles.add(new Tile(imageView4,"yellow","flower"));
            ImageView imageView5=new ImageView(context);
            imageView5.setImageResource(R.drawable.r2);
            tiles.add(new Tile(imageView5,"red","flower"));

            //star
            imageView=new ImageView(context);
            imageView.setImageResource(R.drawable.g3);
            tiles.add(new Tile(imageView,"green","star"));
            imageView1=new ImageView(context);
            imageView1.setImageResource(R.drawable.b3);
            tiles.add(new Tile(imageView1,"blue","star"));
            imageView2=new ImageView(context);
            imageView2.setImageResource(R.drawable.o3);
            tiles.add(new Tile(imageView2,"orange","star"));
            imageView3=new ImageView(context);
            imageView3.setImageResource(R.drawable.p3);
            tiles.add(new Tile(imageView3,"purple","star"));
            imageView4=new ImageView(context);
            imageView4.setImageResource(R.drawable.y3);
            tiles.add(new Tile(imageView4,"yellow","star"));
            imageView5=new ImageView(context);
            imageView5.setImageResource(R.drawable.r3);
            tiles.add(new Tile(imageView5,"red","star"));
            //shape
            imageView=new ImageView(context);
            imageView.setImageResource(R.drawable.g1);
            tiles.add(new Tile(imageView,"green","shape"));
            imageView1=new ImageView(context);
            imageView1.setImageResource(R.drawable.b1);
            tiles.add(new Tile(imageView1,"blue","shape"));
            imageView2=new ImageView(context);
            imageView2.setImageResource(R.drawable.o1);
            tiles.add(new Tile(imageView2,"orange","shape"));
            imageView3=new ImageView(context);
            imageView3.setImageResource(R.drawable.p1);
            tiles.add(new Tile(imageView3,"purple","shape"));
            imageView4=new ImageView(context);
            imageView4.setImageResource(R.drawable.y1);
            tiles.add(new Tile(imageView4,"yellow","shape"));
            imageView5=new ImageView(context);
            imageView5.setImageResource(R.drawable.r1);
            tiles.add(new Tile(imageView5,"red","shape"));
            Collections.shuffle(tiles);
            //square
            imageView=new ImageView(context);
            imageView.setImageResource(R.drawable.g5);
            tiles.add(new Tile(imageView,"green","square"));
            imageView1=new ImageView(context);
            imageView1.setImageResource(R.drawable.b5);
            tiles.add(new Tile(imageView1,"blue","square"));
            imageView2=new ImageView(context);
            imageView2.setImageResource(R.drawable.o5);
            tiles.add(new Tile(imageView2,"orange","square"));
            imageView3=new ImageView(context);
            imageView3.setImageResource(R.drawable.p5);
            tiles.add(new Tile(imageView3,"purple","square"));
            imageView4=new ImageView(context);
            imageView4.setImageResource(R.drawable.y5);
            tiles.add(new Tile(imageView4,"yellow","square"));
            imageView5=new ImageView(context);
            imageView5.setImageResource(R.drawable.r5);
            tiles.add(new Tile(imageView5,"red","square"));
            //circle
            imageView=new ImageView(context);
            imageView.setImageResource(R.drawable.g6);
            tiles.add(new Tile(imageView,"green","circle"));
            imageView1=new ImageView(context);
            imageView1.setImageResource(R.drawable.b6);
            tiles.add(new Tile(imageView1,"blue","circle"));
            imageView2=new ImageView(context);
            imageView2.setImageResource(R.drawable.o6);
            tiles.add(new Tile(imageView2,"orange","circle"));
            imageView3=new ImageView(context);
            imageView3.setImageResource(R.drawable.p6);
            tiles.add(new Tile(imageView3,"purple","circle"));
            imageView4=new ImageView(context);
            imageView4.setImageResource(R.drawable.y6);
            tiles.add(new Tile(imageView4,"yellow","circle"));
            imageView5=new ImageView(context);
            imageView5.setImageResource(R.drawable.r6);
            tiles.add(new Tile(imageView5,"red","circle"));
            //diamond
            imageView=new ImageView(context);
            imageView.setImageResource(R.drawable.g4);
            tiles.add(new Tile(imageView,"green","diamond"));
            imageView1=new ImageView(context);
            imageView1.setImageResource(R.drawable.b4);
            tiles.add(new Tile(imageView1,"blue","diamond"));
            imageView2=new ImageView(context);
            imageView2.setImageResource(R.drawable.o4);
            tiles.add(new Tile(imageView2,"orange","diamond"));
            imageView3=new ImageView(context);
            imageView3.setImageResource(R.drawable.p4);
            tiles.add(new Tile(imageView3,"purple","diamond"));
            imageView4=new ImageView(context);
            imageView4.setImageResource(R.drawable.y4);
            tiles.add(new Tile(imageView4,"yellow","diamond"));
            imageView5=new ImageView(context);
            imageView5.setImageResource(R.drawable.r4);
            tiles.add(new Tile(imageView5,"red","diamond"));
            Collections.shuffle(tiles);

            allTiles =Collections.synchronizedList(new ArrayList<>());
            allTiles.addAll(tiles);
            for (int x=0;x<=1;x++){
                tiles.addAll(allTiles);
            }

            List<Tile> inHandTiles=player.getInHandTiles();

            int t1=r.nextInt(tiles.size()-1); one.setImageDrawable(tiles.get(t1).getImageView().getDrawable());
            inHandTiles.add(tiles.get(t1));new Thread(() -> client.sendMessage("removeFromTiles;"+tiles.get(t1).getColor()+";"+tiles.get(t1).getShape())).start();
            int t2=r.nextInt(tiles.size()-1); two.setImageDrawable(tiles.get(t2).getImageView().getDrawable());
            inHandTiles.add(tiles.get(t2));new Thread(() -> client.sendMessage("removeFromTiles;"+tiles.get(t2).getColor()+";"+tiles.get(t2).getShape())).start();
            int t3=r.nextInt(tiles.size()-1); three.setImageDrawable(tiles.get(t3).getImageView().getDrawable());
            inHandTiles.add(tiles.get(t3));new Thread(() -> client.sendMessage("removeFromTiles;"+tiles.get(t3).getColor()+";"+tiles.get(t3).getShape())).start();
            int t4=r.nextInt(tiles.size()-1); four.setImageDrawable(tiles.get(t4).getImageView().getDrawable());
            inHandTiles.add(tiles.get(t4));new Thread(() -> client.sendMessage("removeFromTiles;"+tiles.get(t4).getColor()+";"+tiles.get(t4).getShape())).start();
            int t5=r.nextInt(tiles.size()-1); five.setImageDrawable(tiles.get(t5).getImageView().getDrawable());
            inHandTiles.add(tiles.get(t5));new Thread(() -> client.sendMessage("removeFromTiles;"+tiles.get(t5).getColor()+";"+tiles.get(t5).getShape())).start();
            int t6=r.nextInt(tiles.size()-1); six.setImageDrawable(tiles.get(t6).getImageView().getDrawable());
            inHandTiles.add(tiles.get(t6));new Thread(() -> client.sendMessage("removeFromTiles;"+tiles.get(t6).getColor()+";"+tiles.get(t6).getShape())).start();

            ids=new String[17][17];
            for (int x=0;x<ids.length;x++){
                for (int y=0;y<ids.length;y++){
                    String id=Integer.toString(context.getResources().getIdentifier("i"+x+"."+y,"id",context.getPackageName())) ;
                    blocks.put(Integer.parseInt(id),new Block());
                    if(x>0){
                        id=id+";"+ context.getResources().getIdentifier("i" + (x - 1) + "." + y, "id", context.getPackageName());
                    }
                    else{ id=id+";"+"none";}
                    if(x<16){
                        id=id+";"+context.getResources().getIdentifier("i"+(x+1)+"."+y, "id", context.getPackageName())  ;
                    }else{ id=id+";"+"none";}
                    if(y>0){
                        id=id+";"+ context.getResources().getIdentifier("i"+x+"."+(y-1), "id", context.getPackageName()) ;
                    }else{ id=id+";"+"none";}
                    if(y<16){
                        id=id+";"+ context.getResources().getIdentifier("i"+x+"."+(y+1), "id", context.getPackageName()) ;
                    }else{ id=id+";"+"none";}
                    ids[x][y]=id;
                }
            }

    }

    public void removeFromTiles(String color,String shape){
        boolean isRemoved=false;
        for(int x=0;x<tiles.size();x++){
            if(tiles.get(x).getShape().equals(shape)&&tiles.get(x).getColor().equals(color)&&!isRemoved){
                tiles.remove(x);isRemoved=true;
            }
        }
    }
    public void addToTiles(String color,String shape){
        boolean isAdded=false;
        for(int x=0;x<allTiles.size();x++){
            if(allTiles.get(x).getShape().equals(shape)&&allTiles.get(x).getColor().equals(color)&&!isAdded){
                tiles.add(allTiles.get(x));isAdded=true;
            }
        }
    }

    public void click(int viewId) {
        if(currentTile==null){
            for(int x=0;x<player.getInHandTiles().size();x++){
                ImageView currentImage=mainActivity.findViewById(viewId);
                if((currentImage.getDrawable()).equals(player.getInHandTiles().get(x).getImageView().getDrawable())){
                    currentTile=player.getInHandTiles().get(x);
                    player.getPositionOfinHandTiles().add(viewId);
                    runOnUiThread(()->{ currentImage.setImageResource(R.drawable.bluebackground);});
                   break;
                }
            }
        }
    }
    public Tile current(String color,String shape){
        for(int x=0;x<allTiles.size();x++){
            if(allTiles.get(x).getShape().equals(shape)&&allTiles.get(x).getColor().equals(color)){
                return allTiles.get(x);
            }
        }
        return null;
    }
    public void onClickFunctionality(int viewId,String color,String shape)  {
        player.setTilePlacement(true);
        final Tile[] current = {current(color, shape)};
        ImageView temp=mainActivity.findViewById(viewId);
        runOnUiThread(()->{ temp.setImageDrawable(current[0].getImageView().getDrawable());
            blocks.get(viewId).setTile(current[0]);
            player.getNewOnBoardTiles().add(current[0]);
            player.getPositionOfNewOnBoardTiles().add(viewId);
            current[0] =null;
            blocks.get(viewId).setValidPlacement(false);
            blocks.get(viewId).setHasTile(true);
            if(player.getPositionOfNewOnBoardTiles().size()==1){
                setPlacementValidityAfterFirstTilePlacement();
            }
            else if(player.getPositionOfNewOnBoardTiles().size()==2){
                setPlacementValidityAfterSecondTilePlacement();
            }
            currentTile=null;
        });


    }
    public void onClick(int viewId)  {
        if(currentTile!=null&&blocks.get(viewId).getValidPlacement().equals(true)){
            if(checkPlacementValidity(viewId,currentTile)&&checkNextToTile(viewId)&&checkForSameTiles(viewId)){
                Thread thread=new Thread(()->{ client.sendMessage("onClickFunctionality;"+viewId+";"+currentTile.getColor()+";"+currentTile.getShape());});
                thread.start();
            }
        }
    }

    public void setPlacementValidityAfterSecondTilePlacement(){
        for(int x=0;x<ids.length;x++){
            for(int y=0;y<ids.length;y++){
                String[] idArray= ids[x][y].split(";");
                if(idArray[0].equals(Integer.toString(player.getPositionOfNewOnBoardTiles().get(0)))){
                    int indexToSetTrue=-1;
                    if(!idArray[1].equals("none")){
                        Block currentBlock= blocks.get(Integer.parseInt(idArray[1]));
                        if(!currentBlock.getHasTile()){
                            setToFalse(idArray[1],1);
                        }
                        else {
                            indexToSetTrue=2;
                        }

                    }
                    if(!idArray[2].equals("none")){
                        Block currentBlock= blocks.get(Integer.parseInt(idArray[2]));
                        if(!currentBlock.getHasTile()){
                            setToFalse(idArray[2],2);
                        }
                        else {
                            indexToSetTrue=1;
                        }
                    }
                    if(!idArray[3].equals("none")){
                        Block currentBlock= blocks.get(Integer.parseInt(idArray[3]));
                        if(!currentBlock.getHasTile()){
                            setToFalse(idArray[3],3);
                        }
                        else {
                            indexToSetTrue=4;
                        }
                    }
                    if(!idArray[4].equals("none")){
                        Block currentBlock= blocks.get(Integer.parseInt(idArray[4]));
                        if(!currentBlock.getHasTile()){
                            setToFalse(idArray[4],4);
                        }
                        else {
                            indexToSetTrue=3;
                        }
                    }
                    if(indexToSetTrue!=-1&&idArray.length!=indexToSetTrue){
                        setToTrue(idArray[indexToSetTrue],indexToSetTrue);
                    }
                }
            }
        }
    }
    public void setPlacementValidityAfterFirstTilePlacement(){
        setPlacementToFalse();
        for(int x=0;x<ids.length;x++){
            for(int y=0;y<ids.length;y++){
                String[] idArray= ids[x][y].split(";");
                if(idArray[0].equals(Integer.toString(player.getPositionOfNewOnBoardTiles().get(0)))){
                    if(!idArray[1].equals("none")){
                        setToTrue(idArray[1],1);
                    }
                    if(!idArray[2].equals("none")){
                        setToTrue(idArray[2],2);
                    }
                    if(!idArray[3].equals("none")){
                        setToTrue(idArray[3],3);
                    }
                    if(!idArray[4].equals("none")){
                        setToTrue(idArray[4],4);
                    }

                }
            }
        }
    }
    public void setToTrue(String id,int index){
        for(int x=0;x<ids.length;x++){
            for (int y=0;y<ids.length;y++){
                String[] idArray= ids[x][y].split(";");
                if(id.equals(idArray[0])){
                    Block currentBlock= blocks.get(Integer.parseInt(idArray[0]));
                    if(!currentBlock.getHasTile()){
                        currentBlock.setValidPlacement(true);
                    }
                    if(idArray.length==index||idArray[index].equals("none")){
                        return;
                    }else{
                        setToTrue(idArray[index],index);
                    }
                }
            }
        }
    }
    public void setToFalse(String id,int index){
        for(int x=0;x<ids.length;x++){
            for (int y=0;y<ids.length;y++){
                String[] idArray=ids[x][y].toString().split(";");
                if(id.equals(idArray[0])){
                    Block currentBlock= blocks.get(Integer.parseInt(idArray[0]));
                    if(!currentBlock.getHasTile()){
                        currentBlock.setValidPlacement(false);
                    }
                    if(idArray.length==index||idArray[index].equals("none")){
                        return;
                    }else{
                        setToTrue(idArray[index],index);
                    }
                }
            }
        }
    }

    public void setPlacementToTrue(){
        for(Map.Entry<Integer,Block> entry:blocks.entrySet()){
            entry.getValue().setValidPlacement(true);
        }
    }
    public void setPlacementToFalse(){
        for(Map.Entry<Integer,Block> entry:blocks.entrySet()){
            entry.getValue().setValidPlacement(false);
        }
    }
    public void setPlacementValidity(){
        for (int x=0;x<ids.length;x++){
            for (int y=0;y<ids.length;y++){
                String[] idArray= ids[x][y].split(";");
                if(blocks.get(Integer.parseInt(idArray[0])).getHasTile()){
                    if(!idArray[1].equals("none")){
                        Block currentBlock= blocks.get(Integer.parseInt(idArray[1]));
                        if(!currentBlock.getHasTile()){
                            currentBlock.setValidPlacement(true);
                        }
                    }
                    if(!idArray[2].equals("none")){
                        Block currentBlock= blocks.get(Integer.parseInt(idArray[2]));
                        if(!currentBlock.getHasTile()){
                            currentBlock.setValidPlacement(true);
                        }
                    }
                    if(!idArray[3].equals("none")){
                        Block currentBlock= blocks.get(Integer.parseInt(idArray[3]));
                        if(!currentBlock.getHasTile()){
                            currentBlock.setValidPlacement(true);
                        }
                    }
                    if(!idArray[4].equals("none")){
                        Block currentBlock= blocks.get(Integer.parseInt(idArray[4]));
                        if(!currentBlock.getHasTile()){
                            currentBlock.setValidPlacement(true);
                        }
                    }
                }
            }
        }
        if(boardIsEmpty()){
            setPlacementToTrue();
        }
    }

    public boolean boardIsEmpty(){

        for(Map.Entry<Integer,Block> entry:blocks.entrySet()){
            if(entry.getValue().getHasTile()){
                return false;
            }
        }
        return true;
    }

    public boolean checkPlacementValidity(int id,Tile tile){
        Boolean result=true;
        for(int x=0;x<ids.length;x++){
            for(int y=0;y<ids.length;y++){
                String[] idArray= ids[x][y].split(";");
                if(idArray[0].equals(Integer.toString(id))){
                    if(!idArray[1].equals("none")){
                        Block currentBlock= blocks.get(Integer.parseInt(idArray[1]));
                        if(currentBlock.getHasTile()){
                            if(tile.getColor().equals(currentBlock.getTile().getColor())){
                                if(!checkColor(idArray[1],1,tile)){
                                    result=false;
                                }
                            }
                            else if(tile.getShape().equals(currentBlock.getTile().getShape())){
                                if(!checkShape(idArray[1],1,tile)){
                                    result=false;
                                }
                            }
                            else{
                                result=false;
                            }
                        }
                    }
                    if(!idArray[2].equals("none")){
                        Block currentBlock= blocks.get(Integer.parseInt(idArray[2]));
                        if(currentBlock.getHasTile()){
                            if(tile.getColor().equals(currentBlock.getTile().getColor())){
                                if(!checkColor(idArray[2],2,tile)){
                                    result=false;
                                }
                            }
                            else if(tile.getShape().equals(currentBlock.getTile().getShape())){
                                if(!checkShape(idArray[2],2,tile)){
                                    result=false;
                                }
                            }
                            else{
                                result=false;
                            }
                        }
                    }
                    if(!idArray[3].equals("none")){
                        Block currentBlock= blocks.get(Integer.parseInt(idArray[3]));
                        if(currentBlock.getHasTile()){
                            if(tile.getColor().equals(currentBlock.getTile().getColor())){
                                if(!checkColor(idArray[3],3,tile)){
                                    result=false;
                                }
                            }
                            else if(tile.getShape().equals(currentBlock.getTile().getShape())){
                                if(!checkShape(idArray[3],3,tile)){
                                    result=false;
                                }
                            }
                            else{
                                result=false;
                            }
                        }
                    }
                    if(!idArray[4].equals("none")){
                        Block currentBlock= blocks.get(Integer.parseInt(idArray[4]));
                        if(currentBlock.getHasTile()){
                            if(tile.getColor().equals(currentBlock.getTile().getColor())){
                                if(!checkColor(idArray[4],4,tile)){
                                    result=false;
                                }
                            }
                            else if(tile.getShape().equals(currentBlock.getTile().getShape())){
                                if(!checkShape(idArray[4],4,tile)){
                                    result=false;
                                }
                            }
                            else{
                                result=false;
                            }
                        }
                    }
                }
            }
        }

        return  result;
    }
    public boolean checkColor(String id,int index,Tile tile){
        for(int x=0;x<ids.length;x++){
            for (int y=0;y<ids.length;y++){
                String[] idArray=ids[x][y].toString().split(";");
                if(id.equals(idArray[0])){
                    if(index<idArray.length&&!idArray[index].equals("none")){
                        Block currentBlock= blocks.get(Integer.parseInt(idArray[index]));
                        if(!(currentBlock.getTile()==(null))){
                            if(!tile.getColor().equals(currentBlock.getTile().getColor())){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    public boolean checkShape(String id,int index,Tile tile){
        for(int x=0;x<ids.length;x++){
            for (int y=0;y<ids.length;y++){
                String[] idArray=ids[x][y].toString().split(";");
                if(id.equals(idArray[0])){
                    if(index<idArray.length&&!idArray[index].equals("none")){
                        Block currentBlock= blocks.get(Integer.parseInt(idArray[index]));
                        if(!(currentBlock.getTile() ==(null))) {
                            if (!tile.getShape().equals(currentBlock.getTile().getShape())) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    public Boolean checkNextToTile(int id){
        if(boardIsEmpty()){return true;}
        Boolean result=true;
        for(int x=0;x<ids.length;x++){
            for(int y=0;y<ids.length;y++){
                String[] idArray= ids[x][y].split(";");
                if(idArray[0].equals(Integer.toString(id))){
                    if(idArray[1].equals("none")&&idArray[4].equals("none")&&!idArray[3].equals("none")&&!idArray[2].equals("none")){
                        Block currentBlock= blocks.get(Integer.parseInt(idArray[3]));
                        Block currentBlock1= blocks.get(Integer.parseInt(idArray[2]));
                        if(!currentBlock.getHasTile()&&!currentBlock1.getHasTile()){result=false;}
                    }
                    else if(idArray[2].equals("none")&&idArray[4].equals("none")&&!idArray[3].equals("none")&&!idArray[1].equals("none")){
                        Block currentBlock= blocks.get(Integer.parseInt(idArray[3]));
                        Block currentBlock1= blocks.get(Integer.parseInt(idArray[1]));
                        if(!currentBlock.getHasTile()&&!currentBlock1.getHasTile()){result=false;}
                    }
                    else if(idArray[1].equals("none")&&idArray[3].equals("none")&&!idArray[4].equals("none")&&!idArray[2].equals("none")){
                        Block currentBlock= blocks.get(Integer.parseInt(idArray[4]));
                        Block currentBlock1= blocks.get(Integer.parseInt(idArray[2]));
                        if(!currentBlock.getHasTile()&&!currentBlock1.getHasTile()){result=false;}
                    }
                    else if(idArray[2].equals("none")&&idArray[3].equals("none")&&!idArray[4].equals("none")&&!idArray[1].equals("none")){
                        Block currentBlock= blocks.get(Integer.parseInt(idArray[4]));
                        Block currentBlock1= blocks.get(Integer.parseInt(idArray[1]));
                        if(!currentBlock.getHasTile()&&!currentBlock1.getHasTile()){result=false;}
                    }
                    else if(idArray[2].equals("none")&&!idArray[1].equals("none")&&!idArray[4].equals("none")&&!idArray[3].equals("none")){
                        Block currentBlock= blocks.get(Integer.parseInt(idArray[1]));
                        Block currentBlock1= blocks.get(Integer.parseInt(idArray[3]));
                        Block currentBlock2= blocks.get(Integer.parseInt(idArray[4]));
                        if(!currentBlock.getHasTile()&&!currentBlock1.getHasTile()&&!currentBlock2.getHasTile()){result=false;}
                    }
                    else if(idArray[1].equals("none")&&!idArray[4].equals("none")&&!idArray[2].equals("none")&&!idArray[3].equals("none")){
                        Block currentBlock= blocks.get(Integer.parseInt(idArray[4]));
                        Block currentBlock1= blocks.get(Integer.parseInt(idArray[2]));
                        Block currentBlock2= blocks.get(Integer.parseInt(idArray[3]));
                        if(!currentBlock.getHasTile()&&!currentBlock1.getHasTile()&&!currentBlock2.getHasTile()){result=false;}
                    }
                    else if(idArray[3].equals("none")&&!idArray[1].equals("none")&&!idArray[2].equals("none")&&!idArray[4].equals("none")){
                        Block currentBlock= blocks.get(Integer.parseInt(idArray[1]));
                        Block currentBlock1= blocks.get(Integer.parseInt(idArray[2]));
                        Block currentBlock2= blocks.get(Integer.parseInt(idArray[4]));
                        if(!currentBlock.getHasTile()&&!currentBlock1.getHasTile()&&!currentBlock2.getHasTile()){result=false;}
                    }
                    else if(idArray[4].equals("none")&&!idArray[1].equals("none")&&!idArray[2].equals("none")&&!idArray[3].equals("none")){
                        Block currentBlock= blocks.get(Integer.parseInt(idArray[1]));
                        Block currentBlock1= blocks.get(Integer.parseInt(idArray[2]));
                        Block currentBlock2= blocks.get(Integer.parseInt(idArray[3]));
                        if(!currentBlock.getHasTile()&&!currentBlock1.getHasTile()&&!currentBlock2.getHasTile()){result=false;}
                    }
                    else if(!idArray[1].equals("none")&&!idArray[2].equals("none")&&!idArray[3].equals("none")&&!idArray[4].equals("none")){
                        Block currentBlock= blocks.get(Integer.parseInt(idArray[1]));
                        Block currentBlock1= blocks.get(Integer.parseInt(idArray[2]));
                        Block currentBlock2= blocks.get(Integer.parseInt(idArray[3]));
                        Block currentBlock3= blocks.get(Integer.parseInt(idArray[4]));
                        if(!currentBlock.getHasTile()&&!currentBlock1.getHasTile()&&!currentBlock2.getHasTile()&&!currentBlock3.getHasTile()){result=false;}
                    }
                }
            }
        }
        return result;
    } 
    public Boolean checkForSameTiles(int id){
        Boolean result=true;
        if(!blocks.get(id).getHasTile()) {
            for (int x = 0; x < ids.length; x++) {
                for (int y = 0; y < ids.length; y++) {
                    String[] idArray = ids[x][y].split(";");
                    if (idArray[0].equals(Integer.toString(id))) {
                        if (!idArray[1].equals("none")) {
                            Block currentBlock = (Block) blocks.get(Integer.parseInt(idArray[1]));
                            int count = 1;
                            String id1 = idArray[1];
                            while (currentBlock.getHasTile() && result && count != 289) {
                                if (currentBlock.getTile().equals(currentTile)) {
                                    result = false;
                                }
                                for (int a = 0; a < ids.length; a++) {
                                    for (int b = 0; b < ids.length; b++) {
                                        String[] idArray1 = ids[a][b].split(";");
                                        if (idArray1[0].equals(id1)) {
                                            if (!idArray1[1].equals("none")) {
                                                currentBlock = (Block) blocks.get(Integer.parseInt(idArray1[1]));
                                                if (currentBlock.getTile() != null) {
                                                    if (currentBlock.getTile().equals(currentTile)) {
                                                        result = false;
                                                    }
                                                }
                                                id1 = idArray1[1];
                                            }

                                        }
                                        count = count + 1;
                                    }
                                }
                            }

                        }
                        if (!idArray[2].equals("none")) {
                            Block currentBlock = (Block) blocks.get(Integer.parseInt(idArray[2]));
                            int count = 1;
                            String id1 = idArray[2];
                            while (currentBlock.getHasTile() && result && count != 289) {
                                if (currentBlock.getTile().equals(currentTile)) {
                                    result = false;
                                }
                                for (int a = 0; a < ids.length; a++) {
                                    for (int b = 0; b < ids.length; b++) {
                                        String[] idArray1 = ids[a][b].split(";");
                                        if (idArray1[0].equals(id1)) {
                                            if (!idArray1[2].equals("none")) {
                                                currentBlock = (Block) blocks.get(Integer.parseInt(idArray1[2]));
                                                if (currentBlock.getTile() != null) {
                                                    if (currentBlock.getTile().equals(currentTile)) {
                                                        result = false;
                                                    }
                                                }
                                                id1 = idArray1[2];
                                            }
                                        }
                                        count = count + 1;
                                    }
                                }
                            }

                        }
                        if (!idArray[3].equals("none")) {
                            Block currentBlock = (Block) blocks.get(Integer.parseInt(idArray[3]));
                            int count = 1;
                            String id1 = idArray[3];
                            while (currentBlock.getHasTile() && result && count != 289) {
                                if (currentBlock.getTile().equals(currentTile)) {
                                    result = false;
                                }
                                for (int a = 0; a < ids.length; a++) {
                                    for (int b = 0; b < ids.length; b++) {
                                        String[] idArray1 = ids[a][b].split(";");
                                        if (idArray1[0].equals(id1)) {
                                            if (!idArray1[3].equals("none")) {
                                                currentBlock = (Block) blocks.get(Integer.parseInt(idArray1[3]));
                                                if (currentBlock.getTile() != null) {
                                                    if (currentBlock.getTile().equals(currentTile)) {
                                                        result = false;
                                                    }
                                                }
                                                id1 = idArray1[3];
                                            }
                                        }
                                        count = count + 1;
                                    }
                                }
                            }

                        }
                        if (!idArray[4].equals("none")) {
                            Block currentBlock = (Block) blocks.get(Integer.parseInt(idArray[4]));
                            int count = 1;
                            String id1 = idArray[4];
                            while (currentBlock.getHasTile() && result && count != 289) {
                                if (currentBlock.getTile().equals(currentTile)) {
                                    result = false;
                                }
                                for (int a = 0; a < ids.length; a++) {
                                    for (int b = 0; b < ids.length; b++) {
                                        String[] idArray1 = ids[a][b].split(";");
                                        if (idArray1[0].equals(id1)) {
                                            if (!idArray1[4].equals("none")) {
                                                currentBlock = (Block) blocks.get(Integer.parseInt(idArray1[4]));
                                                if (currentBlock.getTile() != null) {
                                                    if (currentBlock.getTile().equals(currentTile)) {
                                                        result = false;
                                                    }
                                                }
                                                id1 = idArray1[4];
                                            }
                                        }
                                        count = count + 1;
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
        return result;
    }


    public void undoForAll(int viewId){
        ImageView current=mainActivity.findViewById(viewId);
        runOnUiThread(()->{ current.setImageResource(R.drawable.bluebackground);});
    }
    public void undo(int viewId) throws InterruptedException {
        if(!player.getPositionOfinHandTiles().isEmpty()){
            if(player.getReplace()){
                currentTile=player.getNewOnBoardTiles().get(player.getNewOnBoardTiles().size()-1);
                ImageView current=mainActivity.findViewById(player.getPositionOfNewOnBoardTiles().get(player.getPositionOfNewOnBoardTiles().size()-1));
                ImageView current1=mainActivity.findViewById(player.getPositionOfinHandTiles().get(player.getPositionOfinHandTiles().size()-1));

                runOnUiThread(()->{ current1.setImageDrawable(currentTile.getImageView().getDrawable());currentTile=null;

                if(player.getNewOnBoardTiles().size()==1){
                    current.setImageResource(R.drawable.n1);
                }
                else if(player.getNewOnBoardTiles().size()==2){
                    current.setImageResource(R.drawable.n2);
                }
                else if(player.getNewOnBoardTiles().size()==3){
                    current.setImageResource(R.drawable.n3);
                }
                else if(player.getNewOnBoardTiles().size()==4){
                  current.setImageResource(R.drawable.n4);
                }
                else if(player.getNewOnBoardTiles().size()==5){
                    current.setImageResource(R.drawable.n5);
                }
                else if(player.getNewOnBoardTiles().size()==6){
                     current.setImageResource(R.drawable.n6);
                }
                });
                player.getNewOnBoardTiles().remove(player.getNewOnBoardTiles().size()-1);
                player.getPositionOfNewOnBoardTiles().remove(player.getPositionOfNewOnBoardTiles().size()-1);
                player.getPositionOfinHandTiles().remove(player.getPositionOfinHandTiles().size()-1);
                if(player.getNewOnBoardTiles().isEmpty()){
                    player.setReplace(false);
                   runOnUiThread(()->{ current.setImageResource(R.drawable.swap);});
                }

            }

            else if(currentTile==null&&player.getTilePlacement()){
                currentTile=player.getNewOnBoardTiles().get(player.getNewOnBoardTiles().size()-1);

                ImageView current1=mainActivity.findViewById(player.getPositionOfinHandTiles().get(player.getPositionOfinHandTiles().size()-1));
                runOnUiThread(()->{ current1.setImageDrawable(currentTile.getImageView().getDrawable());

                    Thread thread= new Thread(()->{ client.sendMessage("undoForAll;"+player.getPositionOfNewOnBoardTiles().get(player.getPositionOfNewOnBoardTiles().size()-1));
                    });
                    thread.start();
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    currentTile=null;
                    blocks.get(player.getPositionOfNewOnBoardTiles().get(player.getPositionOfNewOnBoardTiles().size()-1)).setValidPlacement(true);
                    blocks.get(player.getPositionOfNewOnBoardTiles().get(player.getPositionOfNewOnBoardTiles().size()-1)).setHasTile(false);
                    blocks.get(player.getPositionOfNewOnBoardTiles().get(player.getPositionOfNewOnBoardTiles().size()-1)).setTile(null);

                    player.getNewOnBoardTiles().remove(player.getNewOnBoardTiles().size()-1);
                    player.getPositionOfNewOnBoardTiles().remove(player.getPositionOfNewOnBoardTiles().size()-1);
                    player.getPositionOfinHandTiles().remove(player.getPositionOfinHandTiles().size()-1);
                    if(player.getPositionOfNewOnBoardTiles().size()==1){
                        setPlacementValidityAfterFirstTilePlacement();
                    }
                    else if(player.getPositionOfNewOnBoardTiles().size()==2){
                        setPlacementValidityAfterSecondTilePlacement();
                    }

                    if(player.getPositionOfNewOnBoardTiles().isEmpty()){
                        player.setTilePlacement(false);
                        setCountedToFalse();
                        setPlacementValidity();
                    }
                });

            }

            else{
                if(currentTile!=null){
                ImageView current1=mainActivity.findViewById(player.getPositionOfinHandTiles().get(player.getPositionOfinHandTiles().size()-1));
                Thread thread=new Thread(()->{ runOnUiThread(()->{ current1.setImageDrawable(currentTile.getImageView().getDrawable());currentTile=null;}); });
                thread.start();thread.join();
                player.getPositionOfinHandTiles().remove(player.getPositionOfinHandTiles().size()-1);}

            }
        }
        //check if blocks are empty
        Boolean blockHasTile=false;
        for(Map.Entry<Integer,Block> entry:blocks.entrySet()){
            if(entry.getValue().getHasTile()){
                blockHasTile=true;
            }
        }
        if(!blockHasTile){
            setPlacementToTrue();
        }
    }

    public void replace(int viewId) {
        if(!player.getPositionOfinHandTiles().isEmpty()&&!player.getTilePlacement()&&currentTile!=null){
            player.setReplace(true);
            player.getNewOnBoardTiles().add(currentTile);
            player.getPositionOfNewOnBoardTiles().add(viewId);
            if(player.getNewOnBoardTiles().size()==1){
                ImageView temp=mainActivity.findViewById(viewId);
                runOnUiThread(()->{ temp.setImageResource(R.drawable.n1);});
            }
            else if(player.getNewOnBoardTiles().size()==2){
                ImageView temp=mainActivity.findViewById(viewId);
                runOnUiThread(()->{ temp.setImageResource(R.drawable.n2);});
            }
            else if(player.getNewOnBoardTiles().size()==3){
                ImageView temp=mainActivity.findViewById(viewId);
                runOnUiThread(()->{ temp.setImageResource(R.drawable.n3);});
            }
            else if(player.getNewOnBoardTiles().size()==4){
                ImageView temp=mainActivity.findViewById(viewId);
                runOnUiThread(()->{ temp.setImageResource(R.drawable.n4);});
            }
            else if(player.getNewOnBoardTiles().size()==5){
                ImageView temp=mainActivity.findViewById(viewId);
                runOnUiThread(()->{ temp.setImageResource(R.drawable.n5);});
            }
            else if(player.getNewOnBoardTiles().size()==6){
                ImageView temp=mainActivity.findViewById(viewId);
                runOnUiThread(()->{ temp.setImageResource(R.drawable.n6);});
            }
            currentTile=null;
        }
    }

    public void info(int viewId) {
        runOnUiThread(()->{
            AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setMessage(R.string.dialogMessage);

        builder.setCancelable(false);

        builder.setPositiveButton(R.string.Ok, (DialogInterface.OnClickListener) (dialog, which) -> {

            Uri uri = Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.info);

            final VideoView vvw = (VideoView) mainActivity.findViewById(R.id.videoView);
            vvw.setVisibility(View.VISIBLE);
            vvw.setKeepScreenOn(true);
            vvw.setVideoURI(uri);

            View vwVideo = mainActivity.findViewById(R.id.layVideo);
            vwVideo.setVisibility(View.VISIBLE);

            MediaController mediaController = new MediaController(context);
            vvw.setMediaController(mediaController);
            vvw.start();

            vvw.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {

                    View vwVideo = mainActivity.findViewById(R.id.layVideo);
                    vwVideo.setVisibility(View.GONE);
                    VideoView vvw = (VideoView) mainActivity.findViewById(R.id.videoView);
                    vvw.setVisibility(View.GONE);
                    dialog.cancel();
                }
            });
        });

        builder.setNegativeButton(R.string.No, (DialogInterface.OnClickListener) (dialog, which) -> {
            dialog.cancel();
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();});
    }

    public void endTurn(int viewId) throws InterruptedException {
        if(currentTile==null){
            if(player.getReplace()){
                ImageView temporary=mainActivity.findViewById(player.getPositionOfNewOnBoardTiles().get(player.getPositionOfNewOnBoardTiles().size()-1));
                ImageView finalTemporary = temporary;

                 runOnUiThread(()->{ finalTemporary.setImageResource(R.drawable.swap);});
                for(int x=0;x<player.getNewOnBoardTiles().size();x++){
                    int finalX = x;
                    Thread thread= new Thread(()->{client.sendMessage("addToTiles;"+player.getNewOnBoardTiles().get(finalX).getColor()+";"+player.getNewOnBoardTiles().get(finalX).getShape());});
                    thread.start();thread.join();
                }

                for(int x=0;x<player.getNewOnBoardTiles().size();x++){
                    player.getInHandTiles().remove(player.getInHandTiles().indexOf(player.getNewOnBoardTiles().get(x)));
                }
                for(int x=player.getInHandTiles().size();x<6;x++){
                    int t1=r.nextInt(tiles.size()-1);
                    player.getInHandTiles().add(tiles.get(t1));
                    temporary=mainActivity.findViewById(player.getPositionOfinHandTiles().get(player.getPositionOfinHandTiles().size()-1));
                    ImageView finalTemporary1 = temporary;

                     runOnUiThread(()->{ finalTemporary1.setImageDrawable(tiles.get(t1).getImageView().getDrawable()); });

                    Thread thread2=new Thread(()->{ client.sendMessage("removeFromTiles;"+tiles.get(t1).getColor()+";"+tiles.get(t1).getShape()); });
                    thread2.start();

                    player.getPositionOfinHandTiles().remove(player.getPositionOfinHandTiles().size()-1);
                }

                Thread thread5= new Thread(()->{ client.sendMessage("changeTurn;"+player.getId()); });
                thread5.start();

            }
            else if(player.getTilePlacement()){
                pointCount();
                for(int x=0;x<player.getNewOnBoardTiles().size();x++){
                    player.getInHandTiles().remove(player.getInHandTiles().indexOf(player.getNewOnBoardTiles().get(x)));
                }
                for(int x=player.getInHandTiles().size();x<6;x++){
                    if(!tiles.isEmpty()) {
                        int t1 = r.nextInt(tiles.size() - 1);
                        player.getInHandTiles().add(tiles.get(t1));
                        ImageView temporary = mainActivity.findViewById(player.getPositionOfinHandTiles().get(player.getPositionOfinHandTiles().size() - 1));

                        runOnUiThread(() -> {
                                temporary.setImageDrawable(tiles.get(t1).getImageView().getDrawable());
                        });


                        Thread thread2 = new Thread(() -> {
                            client.sendMessage("removeFromTiles;" + tiles.get(t1).getColor() + ";" + tiles.get(t1).getShape());
                        });
                        thread2.start();

                        player.getPositionOfinHandTiles().remove(player.getPositionOfinHandTiles().size()-1);
                    }

                }

                setCountedToFalse();
                Thread thread3= new Thread(()->{ client.sendMessage("setEndTileValidity;    "); });
                thread3.start();

                if(player.getId().equals("1")){
                    new Thread(()->{client.sendMessage("set1;"+player.getName()+";"+player.getPoints()); }).start();
                }
                else if(player.getId().equals("2")){
                    new Thread(()->{client.sendMessage("set2;"+player.getName()+";"+player.getPoints()); }).start();
                }
                else if(player.getId().equals("3")){
                    new Thread(()->{client.sendMessage("set3;"+player.getName()+";"+player.getPoints()); }).start();
                }
                else if(player.getId().equals("4")){
                    new Thread(()->{client.sendMessage("set4;"+player.getName()+";"+player.getPoints()); }).start();
                }

                Thread thread5= new Thread(()->{ client.sendMessage("changeTurn;"+player.getId()); });
                thread5.start();
            }

        }
    }


    public void set1(String name,String points){
        runOnUiThread(()-> {
            TextView textView1=mainActivity.findViewById(R.id.t1);
            if(textView1.getVisibility()==View.GONE){
            textView1.setVisibility(View.VISIBLE);}
            textView1.setText(name + " " + context.getString(R.string.points) + ":" + points);
        });
    }
    public void set2(String name,String points){
        runOnUiThread(()-> {
            TextView textView2=mainActivity.findViewById(R.id.t2);
            if(textView2.getVisibility()==View.GONE){
                textView2.setVisibility(View.VISIBLE);}
            textView2.setText(name + " " + context.getString(R.string.points) + ":" + points);
        });
    }
    public void set3(String name,String points){
        runOnUiThread(()-> {
            TextView textView3=mainActivity.findViewById(R.id.t3);
            if(textView3.getVisibility()==View.GONE){
                textView3.setVisibility(View.VISIBLE);}
            textView3.setText(name + " " + context.getString(R.string.points) + ":" + points);
        });
    }
    public void set4(String name,String points){
        runOnUiThread(()-> {
            TextView textView4=mainActivity.findViewById(R.id.t4);
            if(textView4.getVisibility()==View.GONE){
                textView4.setVisibility(View.VISIBLE);}
            textView4.setText(name + " " + context.getString(R.string.points) + ":" + points);
        });
    }
    public void set5(String name){
        runOnUiThread(()-> {
            TextView textView5=mainActivity.findViewById(R.id.t5);
            textView5.setText(context.getString(R.string.its)+ " " +name + " " + context.getString(R.string.turn));
        });
    }

    public void changeTurn(String id){
        runOnUiThread(()-> {
        int count=0;
        TextView textView=mainActivity.findViewById(R.id.t1);
        if(textView.getVisibility()==View.VISIBLE){count=count+1;}
        textView=mainActivity.findViewById(R.id.t2);
        if(textView.getVisibility()==View.VISIBLE){count=count+1;}
        textView=mainActivity.findViewById(R.id.t3);
        if(textView.getVisibility()==View.VISIBLE){count=count+1;}
        textView=mainActivity.findViewById(R.id.t4);
        if(textView.getVisibility()==View.VISIBLE){count=count+1;}

        if(count==2){
            if(id.equals("1")){
                if(player.getId().equals("1")){player.isturn=false; }
                else if(player.getId().equals("2")){player.isturn=true; }
            }
            else if(id.equals("2")){
                if(player.getId().equals("1")){player.isturn=true; }
                else if(player.getId().equals("2")){player.isturn=false; }
            }

        }
        else if(count==3){
            if(id.equals("1")){
                if(player.getId().equals("1")){player.isturn=false; }
                else if(player.getId().equals("2")){player.isturn=true; }
            }
            else if(id.equals("2")){
                if(player.getId().equals("3")){player.isturn=true; }
                else if(player.getId().equals("2")){player.isturn=false; }
            }
            else if(id.equals("3")){
                if(player.getId().equals("1")){player.isturn=true; }
                else if(player.getId().equals("3")){player.isturn=false; }
            }
        }
        else if(count==4){
            if(id.equals("1")){
                if(player.getId().equals("1")){player.isturn=false; }
                else if(player.getId().equals("2")){player.isturn=true; }
            }
            else if(id.equals("2")){
                if(player.getId().equals("3")){player.isturn=true; }
                else if(player.getId().equals("2")){player.isturn=false; }
            }
            else if(id.equals("3")){
                if(player.getId().equals("4")){player.isturn=true; }
                else if(player.getId().equals("3")){player.isturn=false; }
            }
            else if(id.equals("4")){
                if(player.getId().equals("1")){player.isturn=true; }
                else if(player.getId().equals("4")){player.isturn=false; }
            }
        }

            if(player.isturn){
                new Thread(()->{client.sendMessage("set5;"+player.getName()); }).start();}
        });
    }

    public void setEndTileValidity(){
        setPlacementToFalse();
        setPlacementValidity();
        player.getPositionOfNewOnBoardTiles().clear();
        player.getPositionOfinHandTiles().clear();
        currentTile=null;
        player.getNewOnBoardTiles().clear();
        player.setTilePlacement(false);
        player.setReplace(false);
    }
    public void pointCount(){
         int finalCount=0;
        for(int index=0;index<player.getNewOnBoardTiles().size();index++) {
            int count=0;
            int[] count1 = {0};
            int[] count2 = {0};
            int[] count3 = {0};
            int[] count4 = {0};
            int count6=0;
            for (int x = 0; x < ids.length; x++) {
                for (int y = 0; y < ids.length; y++) {
                    String[] idArray = ids[x][y].split(";");
                    if (idArray[0].equals(Integer.toString(player.getPositionOfNewOnBoardTiles().get(index))))
                    {
                        if(!player.getNewOnBoardTiles().get(index).getCounted()){
                        count=count+1;
                        player.getNewOnBoardTiles().get(index).setCounted(true);}
                        if (!idArray[1].equals("none")) {
                            Block currentBlock = blocks.get(Integer.parseInt(idArray[1]));
                            if (currentBlock.getHasTile()&&!currentBlock.getTile().getCounted()) {
                                count1[0] = count1[0] + 1;currentBlock.getTile().setCounted(true);
                                count(idArray[1],1,count1);
                            }
                        }
                        if (!idArray[2].equals("none")) {
                            Block currentBlock = blocks.get(Integer.parseInt(idArray[2]));
                            if (currentBlock.getHasTile()&&!currentBlock.getTile().getCounted()) {
                                count2[0] = count2[0] + 1;currentBlock.getTile().setCounted(true); count(idArray[2],2,count2);
                            }
                        }
                        if (!idArray[3].equals("none")) {
                            Block currentBlock = blocks.get(Integer.parseInt(idArray[3]));
                            if (currentBlock.getHasTile()&&!currentBlock.getTile().getCounted()) {
                                count3[0] = count3[0] + 1;currentBlock.getTile().setCounted(true);count(idArray[3],3,count3);
                                if(count1[0]!=0){count6=count6+1;} if(count2[0]!=0){count6=count6+1;}
                            }
                        }
                        if (!idArray[4].equals("none")) {
                            Block currentBlock = blocks.get(Integer.parseInt(idArray[4]));
                            if (currentBlock.getHasTile()&&!currentBlock.getTile().getCounted()) {
                                count4[0]= count4[0] + 1;currentBlock.getTile().setCounted(true);count(idArray[4],4,count4);
                                if(count1[0]!=0){count6=count6+1;} if(count2[0]!=0){count6=count6+1;}
                            }
                        }
                        if(count+count2[0]+count1[0]==6){
                            count=count+6;
                        }
                        if(count+count3[0]+count4[0]==6){
                            count=count+6;
                        }
                        finalCount=finalCount+count+count1[0]+count2[0]+count3[0]+count4[0]+count6;
                    }
                }
            }
        }
        player.setPoints(player.getPoints()+finalCount);

    }
    public void count(String id,int index,int[] count){
        for(int x=0;x<ids.length;x++){
            for (int y=0;y<ids.length;y++){
                String[] idArray=ids[x][y].toString().split(";");
                if(id.equals(idArray[0])){
                    Block currentBlock= blocks.get(Integer.parseInt(idArray[0]));
                    if(currentBlock.getHasTile()&&!currentBlock.getTile().getCounted()){
                        count[0]=count[0]+1;currentBlock.getTile().setCounted(true);
                    }
                    if(!currentBlock.getHasTile()||idArray[index].equals("none")){
                        return;
                    }else{
                        count(idArray[index],index,count);
                    }
                }
            }
        }
    }
    public void setCountedToFalse(){
        for(Map.Entry<Integer,Block> entry:blocks.entrySet()){
            if(entry.getValue().getHasTile()){
                if(entry.getValue().getTile().getCounted()){
                    entry.getValue().getTile().setCounted(false);
                }
            }
        }
    }
}



