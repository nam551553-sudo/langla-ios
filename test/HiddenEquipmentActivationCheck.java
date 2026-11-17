package beatdz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.*;
import com.beatdz.langlalau.DesktopLauncher;
import com.beatdz.langlalau.SoftwareRenderer;
import com.langla.balance.EquipmentActivation;
import com.tgame.model.Caption;
import java.lang.reflect.Field;
import java.util.Vector;

public final class HiddenEquipmentActivationCheck {
    public static void main(String[] args) {
        Caption.loadVN();Gdx.files=new LwjglFiles();SoftwareRenderer.install(args);
        LwjglApplicationConfiguration config=new LwjglApplicationConfiguration();config.title="Hidden equipment activation check";config.width=840;config.height=500;
        new LwjglApplication(new AppListener(){
            @Override public void create(){setAppEventListener(new DesktopLauncher());super.create();Gdx.app.postRunnable(()->{
                try{verify();System.out.println("PASS hidden activation in six real account tabs: five elements, matching/universal/expired Tanto, all armor groups, reserve isolation and actual active/inactive tooltip rows.");System.exit(0);}
                catch(Throwable error){error.printStackTrace();System.exit(1);}
            });}
        },config);
    }
    private static void verify() throws Exception {
        DataCenter root=DataCenter.gI();root.MapTemplate=new MapTemplate[0];root.ba=root.bb=true;
        if(root.aP==null){root.aP=new Server();root.aP.name="Local activation test";}
        root.ItemTemplate=new ItemTemplate[1100];
        for(int type=0;type<=15;type++)register(root,1000+type,type);register(root,881,15);
        root.ItemOptionTemplate=new ItemOptionTemplate[29];
        for(int id:new int[]{0,20,22,28}){ItemOptionTemplate t=new ItemOptionTemplate(id);t.name="Activation option "+id+": +#";t.type=(byte)(id==0?0:id==28?4:2);t.strOption="";root.ItemOptionTemplate[id]=t;}
        root.DataTypeItemBody=new DataTypeItemBody[16];for(int type=0;type<16;type++){root.DataTypeItemBody[type]=new DataTypeItemBody();root.DataTypeItemBody[type].type=(byte)type;}
        root.exps=new long[]{1000000};root.Skill=new Skill[0];root.SkillTemplate=new SkillTemplate[0];
        root.DataNameClass=new DataNameClass[6];for(int he=0;he<6;he++){root.DataNameClass[he]=new DataNameClass(he);root.DataNameClass[he].name="Element "+he;}
        MultiSession.select(0);for(int tab=1;tab<6;tab++)require(MultiSession.add(),"open account tab "+tab);
        Char[] owners=new Char[6];
        for(int tab=0;tab<6;tab++){
            MultiSession.select(tab);Char p=owners[tab]=Char.gI();p.name="ActivationAccount"+tab;p.arrItemBag=new Item[30];
            for(int he=1;he<=5;he++){
                p.arrItemBody=new Item[22];p.arrItemBody2=new Item[22];p.idhe=(byte)(he%5+1);
                Item weapon=item(1,he);p.arrItemBody[1]=weapon;require(weapon.a(0,p)==0,"inactive weapon");
                p.idhe=(byte)he;require(weapon.a(0,p)==3,"own element");p.idhe=(byte)(he%5+1);
                Item tanto=item(15,he);p.arrItemBody[15]=tanto;require(weapon.a(0,p)==3,"matching Tanto");tooltip(p,weapon,2);
                tanto.he=(byte)(he%5+1);require(weapon.a(0,p)==0,"wrong Tanto");tooltip(p,weapon,0);
                Item universal=new Item(881);universal.he=0;p.arrItemBody[15]=universal;require(weapon.a(0,p)==3,"universal Tanto");
                universal.expiry=Utlis.time()-1;require(weapon.a(0,p)==0,"expired Tanto");
                p.arrItemBody[15]=null;p.arrItemBody2[15]=tanto;tanto.he=(byte)he;require(weapon.a(0,p)==0,"reserve Tanto must not activate main weapon");
                for(int type=0;type<=9;type++)if(type!=1){
                    p.arrItemBody=new Item[22];Item armor=item(type,he);p.arrItemBody[type]=armor;
                    require(armor.a(0,p)==0,"no support");int first=EquipmentActivation.supportType(type,0),second=EquipmentActivation.supportType(type,1);
                    p.arrItemBody[first]=item(first,he);require(armor.a(0,p)==1,"first support");tooltip(p,armor,1);
                    p.arrItemBody[second]=item(second,he);require(armor.a(0,p)==2,"full group");tooltip(p,armor,2);
                    p.arrItemBody[first].he=(byte)(he%5+1);require(armor.a(0,p)==1,"second support only");
                    p.arrItemBody[second].expiry=Utlis.time()-1;require(armor.a(0,p)==0,"expired support");
                }
            }
            p.arrItemBody=new Item[22];p.idhe=2;p.arrItemBody[1]=item(1,1);if(tab%2==0)p.arrItemBody[15]=item(15,1);
        }
        for(int pass=0;pass<3;pass++)for(int tab=5;tab>=0;tab--){MultiSession.select(tab);Char p=owners[tab];require(p.arrItemBody[1].a(0,p)==(tab%2==0?3:0),"activation stays with the right account");tooltip(p,p.arrItemBody[1],tab%2==0?2:0);}
    }
    private static void tooltip(Char wearer,Item item,int active) throws Exception {
        LangLa_kl panel=new LangLa_kl(GameSrc.gI(),wearer,new Skill[0]);
        LangLa_mk dialog=new LangLa_mk(0,0,1044,panel,item);
        Field field=LangLa_mk.class.getDeclaredField("h");field.setAccessible(true);Vector lines=(Vector)field.get(dialog);
        int on=0,off=0;
        for(Object value:lines){LangLa_gp row=(LangLa_gp)value;if(row.a.startsWith("Activation option 20:")||row.a.startsWith("Activation option 22:")){if(row.b==-7812062)on++;else if(row.b==-7631732)off++;}}
        require(on==active&&on+off==2,"actual tooltip colors: "+on+" active, "+off+" inactive; expected "+active);
    }
    private static void register(DataCenter data,int id,int type){ItemTemplate t=new ItemTemplate(id);t.name="Activation fixture";t.detail="";t.type=(byte)type;t.gioiTinh=2;data.ItemTemplate[id]=t;}
    private static Item item(int type,int element){Item i=new Item(1000+type);i.he=(byte)element;i.strOptions="0,10;20,17;22,23";return i;}
    private static void require(boolean condition,String message){if(!condition)throw new AssertionError(message);}
}
