/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sk8line.usuario.service;

/**
 * 
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
public class Password {
    
    private String salt;
    private String method = "sha256";

    public Password(String salt, String method)
    {
        if (salt == null) {
            //this.salt = substr(sha1(mcrypt_create_iv(22, MCRYPT_DEV_RANDOM)), 0, 22);
        } else {
            this.salt = salt;
        }
        this.method = method;
    }
    public Password(String salt)
    {
        this(salt, "sha265");
    }
    /*
    public function encrypt($senha)
    {
        if ($this->method == 'md5') {
            return md5($this->salt . $senha);
        } elseif ($this->method == 'sha256') {
            return hash('sha256', $this->salt . $senha);
        } elseif ($this->method == 'bcrypt') {
            $bcrypt = new Bcrypt();
            $bcrypt->setCost(14);
            return $bcrypt->create($senha);
        }
    }

    public function getSalt()
    {
        return $this->salt;
    }

    public static function generate($size)
    {
        $alphabet = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%&*() /*-+,.;/:?';
        $pass = array(); //remember to declare $pass as an array
        $alphaLength = strlen($alphabet) - 1; //put the length -1 in cache
        for ($i = 0; $i < $size; $i++) {
            $n = rand(0, $alphaLength);
            $pass[] = $alphabet[$n];
        }
        return implode($pass); //turn the array into a string
    }
    */
}
