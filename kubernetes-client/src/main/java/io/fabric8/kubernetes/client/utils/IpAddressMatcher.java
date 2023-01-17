/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubernetes.client.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
/*
* Excerpt of code by @author Luke Taylor from
* https://github.com/spring-projects/spring-security/blob/master/web/src/main/java/org/springframework/security/web/util/matcher/IpAddressMatcher.java
*
*
* Matches a request based on IP Address or subnet mask matching against the remote
* address.
* <p>
* Both IPv6 and IPv4 addresses are supported, but a matcher which is configured with an
* IPv4 address will never match a request which returns an IPv6 address, and vice-versa.
*
* */
public final class IpAddressMatcher {

  private final InetAddress ipAddress;
  private final int bitMask;

  /**
   * Takes a specific IP address or a range specified using the IP/Netmask (e.g.
   * 192.168.1.0/24 or 202.24.0.0/14).
   *
   * @param ipAddress the address or range of addresses from which the request must
   * come.
   */
  public IpAddressMatcher(String ipAddress) {
    if (ipAddress.indexOf('/') > 0) {
      String[] addressWithMask = ipAddress.split("\\/");
      ipAddress = addressWithMask[0];
      this.bitMask = Integer.parseInt(addressWithMask[1]);
    } else {
      bitMask = -1;
    }
    this.ipAddress = parseAddress(ipAddress);
  }

  public boolean matches(String addressToCheck) {
    InetAddress checkAddress = parseAddress(addressToCheck);

    if (!ipAddress.getClass().equals(checkAddress.getClass())) {
      return false;
    }

    if (bitMask < 0) {
      return checkAddress.equals(ipAddress);
    }

    byte[] checkAddrBytes = checkAddress.getAddress();
    byte[] ipAddrBytes = ipAddress.getAddress();

    int oddBits = bitMask % 8;
    int maskBytes = bitMask / 8 + (oddBits == 0 ? 0 : 1);
    byte[] mask = new byte[maskBytes];

    Arrays.fill(mask, 0, oddBits == 0 ? mask.length : mask.length - 1, (byte) 0xFF);

    if (oddBits != 0) {
      int lastByte = (1 << oddBits) - 1;
      lastByte <<= 8 - oddBits;
      mask[mask.length - 1] = (byte) lastByte;
    }

    for (int i = 0; i < mask.length; i++) {
      if ((checkAddrBytes[i] & mask[i]) != (ipAddrBytes[i] & mask[i])) {
        return false;
      }
    }

    return true;
  }

  private InetAddress parseAddress(String address) {
    try {
      return InetAddress.getByName(address);
    } catch (UnknownHostException e) {
      throw new IllegalArgumentException("Failed to parse ipAddress" + address, e);
    }
  }
}
