/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris;

/**
 *
 * @author p1106501
 */
public class Masque {
    
}

//
//package tetris
//{
//    public class Forme
//    {
//
//        private List<Vecteur[]> points = new List<>();
//        private Vecteur[] vecteurs = new Vecteur[3];
//        private int origine;
//        private int rotation;
//        private int nombreRotation;
//        private string nom;
//
//
//        
//        //===========================================================
//
//
//        public List<int[,]> Points
//        {
//            get { return points; }
//            set { points = value; }
//        }
//        public string Nom
//        {
//            get { return nom; }
//            set { nom = value; }
//        }
//
//        public int[,] Vecteurs
//        {
//            get { return vecteurs; }
//            set { vecteurs = value; }
//        }
//        public int Rotation
//        {
//            get { return rotation; }
//            set
//            {
//                rotation = value;
//                rotation %= nombreRotation;
//            }
//        }
//        public int NombreRotation
//        {
//            get { return nombreRotation; }
//            set { nombreRotation = (value < 0) ? 0 : value; }
//        }
//
//        public int Origine
//        {
//            get { return origine; }
//            set
//            {
//                origine = value;
//                origine %= 4;
//            }
//        }
//
//        public Masques()
//        {
//            rotation = nombreRotation = origine = 0;
//            vecteurs[0, 0] = 0;
//            vecteurs[0, 1] = 0;
//            vecteurs[1, 0] = 0;
//            vecteurs[1, 1] = 0;
//            vecteurs[2, 0] = 0;
//            vecteurs[2, 1] = 0;
//        }
//
//        public Masques(int x1, int y1, int x2, int y2, int x3, int y3)
//        {
//            rotation = nombreRotation = origine = 0;
//            vecteurs[0, 0] = x1;
//            vecteurs[0, 1] = y1;
//            vecteurs[1, 0] = x2;
//            vecteurs[1, 1] = y2;
//            vecteurs[2, 0] = x3;
//            vecteurs[2, 1] = y3;
//            Points = generationPoints(vecteurs, 0);
//        }
//        public Masques(int x1, int y1, int x2, int y2, int x3, int y3, int nbRot)
//        {
//            rotation = origine = 0;
//            nombreRotation = nbRot;
//            vecteurs[0, 0] = x1;
//            vecteurs[0, 1] = y1;
//            vecteurs[1, 0] = x2;
//            vecteurs[1, 1] = y2;
//            vecteurs[2, 0] = x3;
//            vecteurs[2, 1] = y3;
//            if (nbRot == 1)
//                Points = new List<int[,]>(generationPoints(vecteurs, nbRot));
//            else Points = new List<int[,]>(generationPoints(vecteurs, nbRot / 2));
//        }
//        public Masques(string nomMasque, int x1, int y1, int x2, int y2, int x3, int y3, int nbRot)
//        {
//            nom = nomMasque;
//            rotation = origine = 0;
//            nombreRotation = nbRot;
//            vecteurs[0, 0] = x1;
//            vecteurs[0, 1] = y1;
//            vecteurs[1, 0] = x2;
//            vecteurs[1, 1] = y2;
//            vecteurs[2, 0] = x3;
//            vecteurs[2, 1] = y3;
//            if (nbRot == 1)
//                Points = new List<int[,]>(generationPoints(vecteurs, nbRot));
//            else Points = new List<int[,]>(generationPoints(vecteurs, nbRot / 2));
//        }
//
//        //===========================================================
//
//
//        private List<int[,]> generationPoints(int[,] vecteursMasque, int typeRot)
//        {
//            // rotations : (a;b) (-b;a) (-a;-b) (b;-a)
//            int rotation = 0, maxRot, i, j, k, temp;
//            int[,] vec = new int[3,2];
//            vec=vecteursMasque;
//            List<int[,]> listePoints = new List<int[,]>();
//            maxRot = (typeRot<1?1:2*typeRot);
//            int[,] ens = new int[4, 2];
//            ens[0, 0] = 0;
//            ens[0, 1] = 0;
//            for (rotation = 0; rotation < maxRot; rotation++)
//            {
//                for (k = 0; k < 1; k++)
//                {
//                    if (k == 0)
//                    {
//                        ens[0, 0] = 0;
//                        ens[0, 1] = 0;
//                    }
//                    else
//                    {
//                        ens[0, 0] = -vec[k - 1, 0];
//                        ens[0, 1] = -vec[k - 1, 1];
//                    }
//                    for (i = 0; i < 3; i++)
//                    {
//                        for (j = 0; j < 2; j++)
//                        {
//                            ens[i + 1, j] = vec[i, j]+ens[0,j];
//                        }
//                    }
//                    listePoints.Add(ens);
//                    ens = new int[4, 2];
//                }
//                    for (i = 0; i < 3; i++)
//                    {
//                        temp = vec[i, 0];
//                        vec[i, 0] = -vec[i, 1];
//                        vec[i, 1] = temp;
//                    }
//
//            }
//
//            return listePoints;
//        }
//
//        public bool videMasque()
//        {
//            int i, j;
//            for (i = 0; i < 3; i++)
//            {
//                for (j = 0; j < 2; j++)
//                {
//                    if (vecteurs[i, j] != 0) return false;
//                }
//            }
//            return true;
//        }
//
//        public static Masques T()
//        {
//            return new Masques("T", -1, 0, 0, 1, 1, 0, 4);
//        }
//
//        public static Masques L()
//        {
//            return new Masques("L", 1, 0, 0, 1, 0, 2, 4);
//        }
//        public static Masques J()
//        {
//            return new Masques("J", -1, 0, 0, 1, 0, 2, 4);
//        }
//
//        public static Masques C()
//        {
//            return new Masques("C", 1, 0, 1, 1, 0, 1, 4);
//        }
//
//        public static Masques S()
//        {
//            return new Masques("S", 1, 0, 1, 1, 2, 1, 4);
//        }
//
//        public static Masques Z()
//        {
//            return new Masques("Z", 1, 0, 1, -1, 2, -1, 4);
//        }
//    }
//}
