package urban.sandbox.java15.jep339;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Arrays;
import java.util.Base64;

public class Main {

    // https://docs.oracle.com/en/java/javase/15/docs/specs/security/standard-names.html#keypairgenerator-algorithms
    private static final String KP_ALGORITHM = "Ed25519";

    // https://docs.oracle.com/en/java/javase/15/docs/specs/security/standard-names.html#signature-algorithms
    private static final String SG_ALGORITHM = "Ed25519";

    public static void main(final String[] args) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        final KeyPairGenerator kpg = KeyPairGenerator.getInstance(KP_ALGORITHM);
        final KeyPair kp = kpg.generateKeyPair();

        final String rawInput = "abc";
        System.out.println("Raw input: " + rawInput);
        final byte[] input = rawInput.getBytes(StandardCharsets.UTF_8);
        System.out.println("Byte input: " + Arrays.toString(input));

        final byte[] signature = generateSignature(kp.getPrivate(), input);
        System.out.println("Byte signature: " + Arrays.toString(signature));
        System.out.println("Base64 signature: " + Base64.getEncoder().encodeToString(signature));

        final boolean verified = verifySignature(kp.getPublic(), input, signature);
        System.out.println("Verified: " + verified);
    }

    private static byte[] generateSignature(final PrivateKey privateKey, final byte[] input)
            throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        final Signature sig = Signature.getInstance(SG_ALGORITHM);
        sig.initSign(privateKey);
        sig.update(input);
        return sig.sign();
    }

    private static boolean verifySignature(final PublicKey publicKey, final byte[] input, final byte[] signature)
            throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        final Signature sig = Signature.getInstance(SG_ALGORITHM);
        sig.initVerify(publicKey);
        sig.update(input);
        return sig.verify(signature);
    }

}
